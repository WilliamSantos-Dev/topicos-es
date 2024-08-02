package br.edu.ufage.topicos.preco.cadastro;

import br.edu.ufage.topicos.preco.basica.Preco;
import br.edu.ufage.topicos.preco.repositorio.RepositorioPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroPreco implements InterfaceCadastroPreco {
    @Autowired
    private RepositorioPreco repositorioPreco;

    @Override
    public List<Preco> listarPrecosPorProdutoId(Long produtoId) {
        return repositorioPreco.findByProdutoId(produtoId);
    }

    @Override
    public List<Preco> listarPrecosPorPolitica(Long politicaId) {
        return repositorioPreco.findByPolitica_id(politicaId);
    }

    @Override
    public Preco salvarPreco(Preco preco) {
        return repositorioPreco.save(preco);
    }

    @Override
    public List<Preco> listarPrecos() {
        return repositorioPreco.findAll();
    }

    @Override
    public void apagarPreco(Long id) {
        repositorioPreco.deleteById(id);
    }

    @Override
    public void apagarPreco(Preco entity) {
        repositorioPreco.delete(entity);
    }
}
