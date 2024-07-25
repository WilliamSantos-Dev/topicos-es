package br.edu.ufage.topicos.catalogo.controlador.resposta;

import org.modelmapper.ModelMapper;
import br.edu.ufage.topicos.catalogo.basica.Produto;
import br.edu.ufage.topicos.catalogo.config.SpringApplicationContext;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProdutoResponse {

    private long id;
	private String nome;
    private String descricao;
	
	public ProdutoResponse(Produto produto) {
		ModelMapper modelMapper = (ModelMapper) SpringApplicationContext.getBean("modelMapper");
		modelMapper.map(produto, this);
	}
}
