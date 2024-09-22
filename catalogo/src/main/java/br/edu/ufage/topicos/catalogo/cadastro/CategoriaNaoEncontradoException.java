package br.edu.ufage.topicos.catalogo.cadastro;

public class CategoriaNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public CategoriaNaoEncontradoException(String msg) {
		super(msg);
	}
}
