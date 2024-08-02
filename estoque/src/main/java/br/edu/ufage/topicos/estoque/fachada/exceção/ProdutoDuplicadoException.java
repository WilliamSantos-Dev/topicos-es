package br.edu.ufage.topicos.estoque.fachada.exceção;

public class ProdutoDuplicadoException extends RuntimeException {
    public ProdutoDuplicadoException(String message) {
        super(message);
    }
}
