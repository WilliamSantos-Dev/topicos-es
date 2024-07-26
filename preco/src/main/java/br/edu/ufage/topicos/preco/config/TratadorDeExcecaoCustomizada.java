package br.edu.ufage.topicos.preco.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.ufage.topicos.preco.cadastro.PrecoNaoEncontradoException;

@ControllerAdvice
public class TratadorDeExcecaoCustomizada {
	@ExceptionHandler(PrecoNaoEncontradoException.class)
	protected ResponseEntity<Object> tratarExcecaoObjetoNaoEncontrado(PrecoNaoEncontradoException ex) {
		Map<String, String> resposta = new HashMap<>();
		resposta.put("tipo", "PrecoNaoEncontrado");
		resposta.put("mensagem", ex.getMessage());
		
		Map<String, Object> erro = new HashMap<>();
		erro.put("erro", resposta);
		
		return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
	}
}
