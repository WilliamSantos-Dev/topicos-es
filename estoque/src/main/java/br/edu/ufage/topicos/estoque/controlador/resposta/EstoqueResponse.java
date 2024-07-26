package br.edu.ufage.topicos.estoque.controlador.resposta;

import org.modelmapper.ModelMapper;

import br.edu.ufage.topicos.estoque.basica.Estoque;
import br.edu.ufage.topicos.estoque.config.SpringApplicationContext;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EstoqueResponse {
    private long id;
	private Long produtoId;
	private int quantidade;
    private Long armazem_id;

    public EstoqueResponse(Estoque estoque) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(estoque, this);
	}
}
