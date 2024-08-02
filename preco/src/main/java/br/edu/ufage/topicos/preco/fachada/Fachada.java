package br.edu.ufage.topicos.preco.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufage.topicos.preco.basica.Politica;
import br.edu.ufage.topicos.preco.basica.Preco;
import br.edu.ufage.topicos.preco.cadastro.InterfaceCadastroPolitica;
import br.edu.ufage.topicos.preco.cadastro.InterfaceCadastroPreco;

@Component
public class Fachada {

    @Autowired
    private InterfaceCadastroPreco cadastroPreco;

    @Autowired
    private InterfaceCadastroPolitica cadastroPolitica;

    // Métodos de Preco
    public List<Preco> listarPrecos() {
        return cadastroPreco.listarPrecos();
    }

    public List<Preco> listarPrecosPorProduto(Long produtoId) {
        return cadastroPreco.listarPrecosPorProdutoId(produtoId);
    }

    public List<Preco> listarPrecosPorPolitica(Long politicaId) {
        return cadastroPreco.listarPrecosPorPolitica(politicaId);
    }

    public Preco criarPreco(Preco preco) {
        return cadastroPreco.salvarPreco(preco);
    }

    public Preco atualizarPreco(Long id, Preco precoAtualizado) {
        Preco precoExistente = cadastroPreco.listarPrecosPorProdutoId(id).stream().findFirst().orElse(null);
        if (precoExistente != null) {
            precoAtualizado.setId(id);
            return cadastroPreco.salvarPreco(precoAtualizado);
        }
        return null;
    }

    public void apagarPreco(Long id) {
        cadastroPreco.apagarPreco(id);
    }
    
    public List<Politica> listarPoliticas() {
        return cadastroPolitica.listarPoliticas();
    }

    public Politica obterPoliticaPorId(Long id) {
        return cadastroPolitica.obterPoliticaPorId(id);
    }

    public Politica criarPolitica(Politica politica) {
        return cadastroPolitica.salvarPolitica(politica);
    }

    public Politica atualizarPolitica(Long id, Politica politicaAtualizada) {
        Politica politicaExistente = cadastroPolitica.obterPoliticaPorId(id);
        if (politicaExistente != null) {
            politicaAtualizada.setId(id);
            return cadastroPolitica.salvarPolitica(politicaAtualizada);
        }
        return null;
    }

    public void apagarPolitica(Long id) {
        cadastroPolitica.apagarPolitica(id);
    }
}
