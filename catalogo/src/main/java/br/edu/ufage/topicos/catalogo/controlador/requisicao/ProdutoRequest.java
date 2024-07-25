package br.edu.ufage.topicos.catalogo.controlador.requisicao;

import org.modelmapper.ModelMapper;

import br.edu.ufage.topicos.catalogo.basica.Produto;
import br.edu.ufage.topicos.catalogo.config.SpringApplicationContext;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProdutoRequest {

    @NotBlank(message ="O nome do produto é obrigatório")
	private String nome;
	private String descricao;
	
	
	public Produto converterParaClasseBasica() {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		Produto produto = modelMapper.map(this, Produto.class);
		return produto;
		
	}
}
