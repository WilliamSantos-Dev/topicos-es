package br.edu.ufage.topicos.preco.cadastro;

import java.util.List;

import br.edu.ufage.topicos.preco.basica.Preco;

public interface InterfaceCadastroPreco {
    List<Preco> listarPrecosPorProdutoId(Long produtoId);
    List<Preco> listarPrecosPorPolitica(Long politicaId);
    Preco salvarPreco(Preco preco);
    List<Preco> listarPrecos();
    void apagarPreco(Long id);
    void apagarPreco(Preco entity);
}
