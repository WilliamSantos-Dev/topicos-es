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

import br.edu.ufage.topicos.preco.basica.Politica;
import br.edu.ufage.topicos.preco.cadastro.InterfaceCadastroPolitica;

@RestController
@RequestMapping("/preco/politicas/")
public class PoliticaController {

    @Autowired
    private InterfaceCadastroPolitica cadastroPolitica;

    @GetMapping
    public List<Politica> listarPoliticas() {
        return cadastroPolitica.listarPoliticas();
    }

    @GetMapping("preco/{id}")
    public ResponseEntity<Politica> obterPolitica(@PathVariable Long id) {
        Politica politica = cadastroPolitica.obterPoliticaPorId(id);
        if (politica == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(politica);
    }

    @PostMapping
    public Politica criarPolitica(@RequestBody Politica politica) {
        return cadastroPolitica.salvarPolitica(politica);
    }

    @PutMapping("preco/{id}")
    public ResponseEntity<Politica> atualizarPolitica(@PathVariable Long id, @RequestBody Politica politicaAtualizada) {
        Politica politicaExistente = cadastroPolitica.obterPoliticaPorId(id);
        if (politicaExistente == null) {
            return ResponseEntity.notFound().build();
        }
        politicaAtualizada.setId(id);
        Politica politicaSalva = cadastroPolitica.salvarPolitica(politicaAtualizada);
        return ResponseEntity.ok(politicaSalva);
    }

    @DeleteMapping("preco/{id}")
    public ResponseEntity<Void> apagarPolitica(@PathVariable Long id) {
        cadastroPolitica.apagarPolitica(id);
        return ResponseEntity.noContent().build();
    }
}
