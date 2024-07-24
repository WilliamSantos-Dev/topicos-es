package br.edu.ufage.topicos.estoque.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufage.topicos.estoque.basica.Armazem;
import br.edu.ufage.topicos.estoque.repositorio.RepositorioArmazem;

@Service
public class CadastroArmazem implements InterfaceCadastroArmazem {
    @Autowired
    private RepositorioArmazem repositorioArmazem;

    @Override
    public List<Armazem> listarArmazensPorNome(String nome) {
        return repositorioArmazem.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public Armazem salvarArmazem(Armazem entity) {
        return repositorioArmazem.save(entity);
    }

    @Override
    public List<Armazem> listarArmazens() {
        return repositorioArmazem.findAll();
    }

    @Override
    public Optional<Armazem> encontrarArmazemId(Long id) {
        return repositorioArmazem.findById(id);
    }

    @Override
    public void apagarArmazem(Long id) {
        repositorioArmazem.deleteById(id);
    }

    @Override
    public void apagarArmazem(Armazem entity) {
        repositorioArmazem.delete(entity);
    }
}
