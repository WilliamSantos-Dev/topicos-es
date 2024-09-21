package br.edu.ufage.topicos.preco.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufage.topicos.preco.basica.Preco;
import br.edu.ufage.topicos.preco.cadastro.InterfaceCadastroPreco;

@RestController
@RequestMapping("/preco/precos")
public class PrecoController {

    @Autowired
    private InterfaceCadastroPreco cadastroPreco;

    @GetMapping
    public List<Preco> listarPrecos() {
        return cadastroPreco.listarPrecos();
    }

    @GetMapping("/preco/produto/{produtoId}")
    public List<Preco> listarPrecosPorProduto(@PathVariable Long produtoId) {
        return cadastroPreco.listarPrecosPorProdutoId(produtoId);
    }

    @GetMapping("/preco/politica/{politicaId}")
    public List<Preco> listarPrecosPorPolitica(@PathVariable Long politicaId) {
        return cadastroPreco.listarPrecosPorPolitica(politicaId);
    }

    @PostMapping
    public Preco criarPreco(@RequestBody Preco preco) {
        return cadastroPreco.salvarPreco(preco);
    }

    @PutMapping("/preco/{id}")
    public ResponseEntity<Preco> atualizarPreco(@PathVariable Long id, @RequestBody Preco precoAtualizado) {
        Preco precoExistente = cadastroPreco.listarPrecosPorProdutoId(id).stream().findFirst().orElse(null);
        if (precoExistente == null) {
            return ResponseEntity.notFound().build();
        }
        precoAtualizado.setId(id);
        Preco precoSalvo = cadastroPreco.salvarPreco(precoAtualizado);
        return ResponseEntity.ok(precoSalvo);
    }

    @DeleteMapping("/preco/{id}")
    public ResponseEntity<Void> apagarPreco(@PathVariable Long id) {
        cadastroPreco.apagarPreco(id);
        return ResponseEntity.noContent().build();
    }
}
