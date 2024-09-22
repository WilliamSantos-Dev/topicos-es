package br.edu.ufage.topicos.estoque.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufage.topicos.estoque.basica.Armazem;
import br.edu.ufage.topicos.estoque.basica.Estoque;
import br.edu.ufage.topicos.estoque.cadastro.Exceptions.ArmazemNaoEncontradoException;
import br.edu.ufage.topicos.estoque.cadastro.Exceptions.ObjetoNaoEncontradoException;
import br.edu.ufage.topicos.estoque.controlador.requesicao.EstoqueRequest;
import br.edu.ufage.topicos.estoque.fachada.exceção.EstoqueNaoEncontradoException;
import br.edu.ufage.topicos.estoque.repositorio.RepositorioArmazem;
import br.edu.ufage.topicos.estoque.repositorio.RepositorioEstoque;

@Service
public class CadastroEstoque implements InterfaceCadastroEstoque {
    @Autowired
    private RepositorioEstoque repositorioEstoque;

    @Autowired
    private RepositorioArmazem repositorioArmazem;

    @Override
    public List<Estoque> listarEstoquesPorProdutoId(long produtoId) {
        return repositorioEstoque.findByProdutoId(produtoId);
    }

    @Override
    public List<Estoque> listarEstoquesPorArmazem(long armazemId) {
        return repositorioEstoque.findByArmazem_id(armazemId);
    }

    @Override
    public Estoque salvarEstoque(Estoque entity) {
        return repositorioEstoque.save(entity);
    }

    @Override
    public List<Estoque> listarEstoques() {
        return repositorioEstoque.findAll();
    }

    @Override
    public void apagarEstoque(Long id) throws EstoqueNaoEncontradoException {
        if (!repositorioEstoque.existsById(id)) {
            throw new EstoqueNaoEncontradoException("Estoque com ID " + id + " não encontrado.");
        }
        repositorioEstoque.deleteById(id);
    }

    @Override
    public void apagarEstoque(Estoque entity) {
        repositorioEstoque.delete(entity);
    }

    @Override
    public Estoque encontrarEstoquePorProdutoEArmazem(long produtoId, long armazemId) {
        return repositorioEstoque.findByProdutoIdAndArmazem_id(produtoId, armazemId);
    }
   
    
    @Override
    public Estoque atualizarEstoque(Long id, EstoqueRequest request) {
        
     
        Optional<Estoque> estoqueOptional = repositorioEstoque.findById(id);
    
        if (!estoqueOptional.isPresent()) {
            throw new ObjetoNaoEncontradoException("Estoque com o ID " + id + " não encontrado");
        }       

        Estoque estoque = estoqueOptional.get();

        Armazem armazem = repositorioArmazem.findById(request.getArmazem_id())
            .orElseThrow(() -> new ArmazemNaoEncontradoException("Armazém com o ID " + request.getArmazem_id() + " não encontrado"));

        estoque.setQuantidade(request.getQuantidade());
        estoque.setProdutoId(request.getProdutoId());
        estoque.setArmazem(armazem); 
        return repositorioEstoque.save(estoque);
    }

    

}
