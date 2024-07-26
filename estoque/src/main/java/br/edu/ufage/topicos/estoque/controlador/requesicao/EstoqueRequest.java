package br.edu.ufage.topicos.estoque.controlador.requesicao;

import org.modelmapper.ModelMapper;

import br.edu.ufage.topicos.estoque.basica.Estoque;
import br.edu.ufage.topicos.estoque.config.SpringApplicationContext;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EstoqueRequest {
    @NotNull(message ="Passe a informação do produto")
	private Long produtoId;
    @NotNull(message ="Passe a quantidade do produto")
	private int quantidade;
    @NotNull(message ="Passe a informação do estoque")
    private Long armazem_id;


    public Estoque converterParaClasseBasica() {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		Estoque estoque = modelMapper.map(this, Estoque.class);
		return estoque;
		
	}
}
