package br.edu.ufage.topicos.estoque.controlador;

import org.springframework.web.bind.annotation.RestController;

import br.edu.ufage.topicos.estoque.basica.Armazem;
import br.edu.ufage.topicos.estoque.basica.Estoque;
import br.edu.ufage.topicos.estoque.cadastro.Exceptions.ArmazemNaoEncontradoException;
import br.edu.ufage.topicos.estoque.controlador.requesicao.ArmazemRequest;
import br.edu.ufage.topicos.estoque.controlador.requesicao.EstoqueRequest;
import br.edu.ufage.topicos.estoque.controlador.resposta.ArmazemResponse;
import br.edu.ufage.topicos.estoque.controlador.resposta.EstoqueResponse;
import br.edu.ufage.topicos.estoque.fachada.EstoqueFachada;
import br.edu.ufage.topicos.estoque.fachada.exceção.EstoqueNaoEncontradoException;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/estoque")
public class ControladorEstoque {

    @Autowired
    private EstoqueFachada estoque;

    @PostMapping()
    Estoque cadastroEstoque(@Valid @RequestBody EstoqueRequest newObj) {
        Estoque estoqueobj = newObj.converterParaClasseBasica();

        Armazem armazem = estoque.encontrarArmazemId(newObj.getArmazem_id());
        estoqueobj.setArmazem(armazem);

        return estoque.adicionarEstoque(estoqueobj);
    }

    @GetMapping()
    List<EstoqueResponse> listarEstoques() {
        List<EstoqueResponse> response = new ArrayList<EstoqueResponse>();
        for (Estoque e : estoque.listarEstoques())
            response.add(new EstoqueResponse(e));
        return response;
    }

    @GetMapping("/produto/{id}")
    List<EstoqueResponse> listarEstoquePorProduto(@PathVariable Long id) {
        List<EstoqueResponse> response = new ArrayList<EstoqueResponse>();
        for (Estoque e : estoque.listarEstoquesPorProdutoId(id))
            response.add(new EstoqueResponse(e));
        return response;
    }

    @GetMapping("/estoqueporarmazem/{id}")
    List<EstoqueResponse> listarEstoquePorArmazem(@PathVariable Long id) {
        List<EstoqueResponse> response = new ArrayList<EstoqueResponse>();
        for (Estoque e : estoque.listarEstoquesPorArmazem(id))
            response.add(new EstoqueResponse(e));
        return response;
    }

    @DeleteMapping("/{id}")
    public void removerEstoque(@PathVariable Long id) throws EstoqueNaoEncontradoException {
        estoque.removerEstoque(id);
    }

   @PutMapping("/{id}")
    public ResponseEntity<EstoqueResponse> atualizarEstoque(@PathVariable Long id, @RequestBody EstoqueRequest request) {
        Estoque atualizado = estoque.atualizarEstoque(id, request);
        return ResponseEntity.ok(new EstoqueResponse(atualizado));
    }

}
