package br.edu.ufage.topicos.catalogo.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufage.topicos.catalogo.basica.Categoria;
import br.edu.ufage.topicos.catalogo.basica.Produto;
import br.edu.ufage.topicos.catalogo.repositorio.RepositorioProduto;

@Service
public class CadastroProduto implements InterfaceCadastroProduto {
	@Autowired
	private RepositorioProduto repositorioProduto;

	@Override
	public List<Produto> listarProdutos(String descricao) {
		return repositorioProduto.findByDescricaoContainingIgnoreCase(descricao);
	}

	@Override
	public List<Produto> listarProdutosPorCategoria(String nome) {
		return repositorioProduto.findByCategoria_nome(nome);
	}

	@Override
	public  Produto salvarProduto(Produto entity) {
		return repositorioProduto.save(entity);
	}

	@Override
	public List<Produto> listarProdutos() {
		return repositorioProduto.findAll();
	}

	@Override
	public Produto encontrarProdutoId(Long id) {
		Optional<Produto> optional = repositorioProduto.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			throw new ObjetoNaoEncontradoException("Não existe produto com o id: " + id);
		}
	}

	@Override
	public void apagarProduto(Long id) {
		repositorioProduto.deleteById(id);
	}

	@Override
	public void apagarProduto(Produto entity) {
		repositorioProduto.delete(entity);
	}
	

}
