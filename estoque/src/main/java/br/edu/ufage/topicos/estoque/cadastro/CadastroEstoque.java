package br.edu.ufage.topicos.estoque.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufage.topicos.estoque.basica.Estoque;
import br.edu.ufage.topicos.estoque.repositorio.RepositorioEstoque;

@Service
public class CadastroEstoque implements InterfaceCadastroEstoque {
    @Autowired
    private RepositorioEstoque repositorioEstoque;

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
    public void apagarEstoque(Long id) {
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
}
