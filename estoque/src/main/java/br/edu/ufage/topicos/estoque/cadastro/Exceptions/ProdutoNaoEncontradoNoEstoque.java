package br.edu.ufage.topicos.estoque.cadastro.Exceptions;

public class ProdutoNaoEncontradoNoEstoque extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ProdutoNaoEncontradoNoEstoque(String msg) {
        super(msg);
    }
}
