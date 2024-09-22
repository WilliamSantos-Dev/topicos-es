package br.edu.ufage.topicos.catalogo.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufage.topicos.catalogo.basica.Categoria;
import br.edu.ufage.topicos.catalogo.basica.Produto;
import br.edu.ufage.topicos.catalogo.cadastro.ObjetoNaoEncontradoException;
import br.edu.ufage.topicos.catalogo.controlador.requisicao.ProdutoRequest;
import br.edu.ufage.topicos.catalogo.controlador.resposta.ProdutoResponse;
import br.edu.ufage.topicos.catalogo.fachada.Catalogo;
import br.edu.ufage.topicos.catalogo.message.Event;
import br.edu.ufage.topicos.catalogo.message.Publisher;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/catalogo/produto")
public class ControladorProduto {
    @Autowired
    private Catalogo catalogo;

    @Autowired
    private Publisher publisher;

    @PostMapping()
    Produto cadastrarProduto(@Valid @RequestBody ProdutoRequest newObj) {
        Produto produto = catalogo.salvarProduto(newObj.converterParaClasseBasica());
        Event<Long, Integer> event = new Event<>(Event.Type.CREATE, produto.getId(), 2);
        publisher.sendEvent(event);
        return produto;
    }

    @GetMapping()
    List<ProdutoResponse> listarProdutos() {
        List<ProdutoResponse> response = new ArrayList<ProdutoResponse>();
        for (Produto p : catalogo.listarProdutos())
            response.add(new ProdutoResponse(p));
        return response;
    }

    @GetMapping("/{id}")
    ProdutoResponse carregarProduto(@PathVariable long id) {
        return new ProdutoResponse(catalogo.encontrarProdutoId(id));
    }

    @DeleteMapping("/{id}")
    void apagarProduto(@PathVariable Long id) {
        catalogo.apagarProduto(id);
    }

    @PutMapping()
    Produto atualizarProduto(@Valid @RequestBody Produto newProduto) {

        Produto produtoAux = catalogo.encontrarProdutoId(newProduto.getId());
		if(produtoAux.getId() == newProduto.getId()) {
			Produto produto = catalogo.salvarProduto(newProduto);
            return produto;
		} else {
			throw new ObjetoNaoEncontradoException("Não existe produto com o id: " + newProduto.getId());
		}
    }

}
