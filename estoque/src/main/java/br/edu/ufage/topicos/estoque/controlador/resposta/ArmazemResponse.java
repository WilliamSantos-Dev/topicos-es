package br.edu.ufage.topicos.estoque.controlador.resposta;

import org.modelmapper.ModelMapper;

import br.edu.ufage.topicos.estoque.basica.Armazem;
import br.edu.ufage.topicos.estoque.config.SpringApplicationContext;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ArmazemResponse {
    private long id;
    private String nome;
    private String localizacao;

    public ArmazemResponse(Armazem armazem) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(armazem, this);
	}
}
