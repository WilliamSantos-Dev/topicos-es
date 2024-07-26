package br.edu.ufage.topicos.estoque.cadastro;
import java.util.List;

import br.edu.ufage.topicos.estoque.basica.Estoque;

public interface InterfaceCadastroEstoque {

    List<Estoque> listarEstoquesPorProdutoId(long produtoId);

    List<Estoque> listarEstoquesPorArmazem(long armazemId);

    Estoque salvarEstoque(Estoque entity);

    List<Estoque> listarEstoques();

    void apagarEstoque(Long id);

    void apagarEstoque(Estoque entity);

    Estoque encontrarEstoquePorProdutoEArmazem(long produtoId, long armazemId);
}
