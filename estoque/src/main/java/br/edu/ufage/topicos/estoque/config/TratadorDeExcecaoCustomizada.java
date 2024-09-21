package br.edu.ufage.topicos.estoque.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.ufage.topicos.estoque.cadastro.Exceptions.ArmazemNaoEncontradoException;
import br.edu.ufage.topicos.estoque.cadastro.Exceptions.ProdutoNaoEncontradoNoEstoque;
import br.edu.ufage.topicos.estoque.fachada.exceção.ProdutoDuplicadoException;

@ControllerAdvice
public class TratadorDeExcecaoCustomizada {
	
	@ExceptionHandler(ProdutoNaoEncontradoNoEstoque.class)
	protected ResponseEntity<Object> tratarExcecaoObjetoNaoEncontrado(ProdutoNaoEncontradoNoEstoque ex) {
		Map<String, String> resposta = new HashMap<>();
		resposta.put("tipo", "ProdutoNaoEncontradoNoEstoque");
		resposta.put("mensagem", ex.getMessage());
		
		Map<String, Object> erro = new HashMap<>();
		erro.put("erro", resposta);
		
		return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ArmazemNaoEncontradoException.class)
	protected ResponseEntity<Object> tratarExcecaoArmazemNaoEncontrado(ArmazemNaoEncontradoException ex) {
		Map<String, String> resposta = new HashMap<>();
		resposta.put("tipo", "ArmazemNaoEncontradoException");
		resposta.put("mensagem", ex.getMessage());
		
		Map<String, Object> erro = new HashMap<>();
		erro.put("erro", resposta);
		
		return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ProdutoDuplicadoException.class)
	protected ResponseEntity<Object> tratarExcecaoProdutoDuplicado(ProdutoDuplicadoException ex) {
		Map<String, String> resposta = new HashMap<>();
		resposta.put("tipo", "ProdutoDuplicadoException");
		resposta.put("mensagem", ex.getMessage());
		
		Map<String, Object> erro = new HashMap<>();
		erro.put("erro", resposta);
		
		return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
	}
}
