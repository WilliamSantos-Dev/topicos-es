package br.edu.ufage.topicos.preco.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufage.topicos.preco.basica.Politica;
import br.edu.ufage.topicos.preco.repositorio.RepositorioPolitica;

@Service
public class CadastroPolitica implements InterfaceCadastroPolitica {

    @Autowired
    private RepositorioPolitica repositorioPolitica;

    @Override
    public List<Politica> listarPoliticas() {
        return repositorioPolitica.findAll();
    }

    @Override
    public Politica obterPoliticaPorId(Long id) {
        return repositorioPolitica.findById(id).orElse(null);
    }

    @Override
    public Politica salvarPolitica(Politica politica) {
        return repositorioPolitica.save(politica);
    }

    @Override
    public void apagarPolitica(Long id) {
        repositorioPolitica.deleteById(id);
    }
}
