package br.edu.ufage.topicos.preco.controlador;

import br.edu.ufage.topicos.preco.basica.Politica;
import br.edu.ufage.topicos.preco.cadastro.InterfaceCadastroPolitica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/politicas")
public class PoliticaController {

    @Autowired
    private InterfaceCadastroPolitica cadastroPolitica;

    @GetMapping
    public List<Politica> listarPoliticas() {
        return cadastroPolitica.listarPoliticas();
    }

    @GetMapping("/{id}")
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

    @PutMapping("/{id}")
    public ResponseEntity<Politica> atualizarPolitica(@PathVariable Long id, @RequestBody Politica politicaAtualizada) {
        Politica politicaExistente = cadastroPolitica.obterPoliticaPorId(id);
        if (politicaExistente == null) {
            return ResponseEntity.notFound().build();
        }
        politicaAtualizada.setId(id);
        Politica politicaSalva = cadastroPolitica.salvarPolitica(politicaAtualizada);
        return ResponseEntity.ok(politicaSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarPolitica(@PathVariable Long id) {
        cadastroPolitica.apagarPolitica(id);
        return ResponseEntity.noContent().build();
    }
}
