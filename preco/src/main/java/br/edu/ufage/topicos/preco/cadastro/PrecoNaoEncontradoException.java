package br.edu.ufage.topicos.preco.cadastro;

public class PrecoNaoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PrecoNaoEncontradoException(String msg) {
        super(msg);
    }
}
