package br.edu.ufage.topicos.estoque.controlador.requesicao;

import org.modelmapper.ModelMapper;
import br.edu.ufage.topicos.estoque.basica.Armazem;
import br.edu.ufage.topicos.estoque.config.SpringApplicationContext;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ArmazemRequest {
    @NotBlank(message ="O nome do armazém é obrigatório")
    private String nome;
    @NotBlank(message ="A localização do armazém é obrigatória")
    private String localizacao;

    public Armazem converterParaClasseBasica() {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		Armazem armazem = modelMapper.map(this, Armazem.class);
		return armazem;
		
	}
}
