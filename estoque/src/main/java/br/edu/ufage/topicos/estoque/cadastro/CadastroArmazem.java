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
    public Armazem encontrarArmazemId(Long id) {
        Optional<Armazem> optional = repositorioArmazem.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			throw new ObjetoNaoEncontradoException("Não existe produto com o id: " + id);
		}
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
