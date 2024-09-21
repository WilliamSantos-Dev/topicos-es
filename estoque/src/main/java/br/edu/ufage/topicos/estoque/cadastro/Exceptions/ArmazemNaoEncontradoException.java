package br.edu.ufage.topicos.estoque.cadastro.Exceptions;

public class ArmazemNaoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ArmazemNaoEncontradoException(String msg) {
        super(msg);
    }
}
