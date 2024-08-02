package br.edu.ufage.topicos.preco.cadastro;

import br.edu.ufage.topicos.preco.basica.Preco;

import java.util.List;

public interface InterfaceCadastroPreco {
    List<Preco> listarPrecosPorProdutoId(Long produtoId);
    List<Preco> listarPrecosPorPolitica(Long politicaId);
    Preco salvarPreco(Preco preco);
    List<Preco> listarPrecos();
    void apagarPreco(Long id);
    void apagarPreco(Preco entity);
}
