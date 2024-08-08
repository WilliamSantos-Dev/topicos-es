package br.edu.ufage.topicos.catalogo.controlador;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufage.topicos.catalogo.basica.Categoria;
import br.edu.ufage.topicos.catalogo.controlador.requisicao.CategoriaRequest;
import br.edu.ufage.topicos.catalogo.controlador.resposta.CategoriaResponse;
import br.edu.ufage.topicos.catalogo.fachada.Catalogo;
import jakarta.validation.Valid;

@RestController
public class ControladorCategoria {
	@Autowired
	private Catalogo catalogo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@PostMapping("/categoria")
	Categoria cadastrarCategoria(@Valid @RequestBody CategoriaRequest newObj) {
		Categoria categoria = catalogo.salvarCategoria(newObj.converterParaClasseBasica());
		rabbitTemplate.convertAndSend("categoriaQueue", categoria);
		return categoria;
	}

	@GetMapping("/categoria")
	List<CategoriaResponse> listarCategorias() {
		List<CategoriaResponse> response = new ArrayList<CategoriaResponse>();
		for (Categoria c : catalogo.listarCategorias())
			response.add(new CategoriaResponse(c));
		return response;
	}

	@GetMapping("/categoria/{id}")
	CategoriaResponse carregarCategoria(@PathVariable long id) {
		return new CategoriaResponse(catalogo.encontrarCategoria(id));
	}

}
