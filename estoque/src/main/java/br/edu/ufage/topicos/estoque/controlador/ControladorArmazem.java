package br.edu.ufage.topicos.estoque.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufage.topicos.estoque.basica.Armazem;
import br.edu.ufage.topicos.estoque.controlador.requesicao.ArmazemRequest;
import br.edu.ufage.topicos.estoque.controlador.resposta.ArmazemResponse;
import br.edu.ufage.topicos.estoque.fachada.EstoqueFachada;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/estoque/armazem")
public class ControladorArmazem {

    @Autowired
    private EstoqueFachada estoque;

    @PostMapping()
    Armazem cadastroArmazem(@Valid @RequestBody ArmazemRequest newObj) {
        return estoque.adicionarArmazem(newObj.converterParaClasseBasica());
    }

    @GetMapping()
    List<ArmazemResponse> listarArmazem() {
        List<ArmazemResponse> response = new ArrayList<ArmazemResponse>();
        for (Armazem a : estoque.listarArmazens())
            response.add(new ArmazemResponse(a));
        return response;
    }

    @GetMapping("/{id}")
    ArmazemResponse buscarArmazem(@PathVariable Long id) {
        return new ArmazemResponse(estoque.encontrarArmazemId(id));
    }

    @DeleteMapping("/{id}")
    void removerArmazem(@PathVariable Long id) {
        estoque.removerArmazem(id);
    }

}
