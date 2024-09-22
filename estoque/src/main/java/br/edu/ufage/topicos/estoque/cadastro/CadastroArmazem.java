package br.edu.ufage.topicos.estoque.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufage.topicos.estoque.basica.Armazem;
import br.edu.ufage.topicos.estoque.cadastro.Exceptions.ArmazemNaoEncontradoException;
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
    public Armazem atualizarArmazem(Long id, Armazem novoArmazem) throws ArmazemNaoEncontradoException {
        Optional<Armazem> armazemExistente = repositorioArmazem.findById(id);
        
        if (armazemExistente.isPresent()) {
            Armazem armazem = armazemExistente.get();
            armazem.setNome(novoArmazem.getNome());
            armazem.setLocalizacao(novoArmazem.getLocalizacao());
           
            return repositorioArmazem.save(armazem);
        } else {
            throw new ArmazemNaoEncontradoException("Armazém com ID " + id + " não encontrado.");
        }
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
			throw new ArmazemNaoEncontradoException("Não existe armazem com o id: " + id);
		}
    }

    @Override
    public void apagarArmazem(Long id) {
        Optional<Armazem> optional = repositorioArmazem.findById(id);
		if(optional.isPresent()) {
            repositorioArmazem.deleteById(id);
		} else{
            throw new ArmazemNaoEncontradoException("Não existe armazem com o id: " + id);
        }         
    }

    @Override
    public void apagarArmazem(Armazem entity) {
        repositorioArmazem.delete(entity);
    }
}
