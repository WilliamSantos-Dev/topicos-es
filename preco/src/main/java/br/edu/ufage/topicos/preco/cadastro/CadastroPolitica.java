package br.edu.ufage.topicos.preco.cadastro;

import br.edu.ufage.topicos.preco.basica.Politica;
import br.edu.ufage.topicos.preco.repositorio.RepositorioPolitica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroPolitica implements InterfaceCadastroPolitica {
    @Autowired
    private RepositorioPolitica repositorioPolitica;

    @Override
    public List<Politica> listarPoliticasPorTipo(String tipo) {
        return repositorioPolitica.findByTipoContainingIgnoreCase(tipo);
    }

    @Override
    public Politica salvarPolitica(Politica entity) {
        return repositorioPolitica.save(entity)
    }

    @Override
    public List<Politica> listarPoliticas() {
        return repositorioPolitica.findAll();
    }

    @Override
    public Optional<Politica> encontrarPolitica(Long id) {
        return repositorioPolitica.findById(id);
    }

    @Override
    public void apagarPolitica(Long id) {
        repositorioPolitica.deleteById(id);
    }

    @Override
    public void apagarPolitica(Politica entity) {
        repositorioPolitica.delete(entity);
    }
}
