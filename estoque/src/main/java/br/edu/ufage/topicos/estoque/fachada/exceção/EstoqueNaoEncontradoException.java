package br.edu.ufage.topicos.estoque.fachada.exceção;

public class EstoqueNaoEncontradoException extends Exception {
    public EstoqueNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}