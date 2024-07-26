package br.edu.ufage.topicos.estoque.fachada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import br.edu.ufage.topicos.estoque.basica.Armazem;
import br.edu.ufage.topicos.estoque.basica.Estoque;
import br.edu.ufage.topicos.estoque.cadastro.InterfaceCadastroArmazem;
import br.edu.ufage.topicos.estoque.cadastro.InterfaceCadastroEstoque;
import br.edu.ufage.topicos.estoque.cadastro.ObjetoNaoEncontradoException;

@Service
public class EstoqueFachada {
    
    @Autowired
    InterfaceCadastroArmazem cadastroArmazem;

    @Autowired
    InterfaceCadastroEstoque cadastroEstoque;

    public Armazem adicionarArmazem(Armazem entity){
        return cadastroArmazem.salvarArmazem(entity);
    }

    public void removerArmazem(Long id){
        cadastroArmazem.apagarArmazem(id);
    }

    public void removerArmazem(Armazem entity){
        cadastroArmazem.apagarArmazem(entity);
    }

    public List<Armazem> listarArmazens(){
        return cadastroArmazem.listarArmazens();
    }

    public Armazem encontrarArmazemId(Long id){
        return cadastroArmazem.encontrarArmazemId(id);
    }

    public Estoque adicionarEstoque(Estoque entity){

        Estoque estoqueExistente = cadastroEstoque.encontrarEstoquePorProdutoEArmazem(entity.getProdutoId(), entity.getArmazem().getId());

        if (estoqueExistente != null) {
            throw new RuntimeException("Estoque já existe para o produto e armazém informados");
        }

        return cadastroEstoque.salvarEstoque(entity);
    }

    public void removerEstoque(Long id){
        cadastroEstoque.apagarEstoque(id);
    }

    public void removerEstoque(Estoque entity){
        cadastroEstoque.apagarEstoque(entity);
    }

    public List<Estoque> listarEstoques(){
        return cadastroEstoque.listarEstoques();
    }

    public List<Estoque> listarEstoquesPorProdutoId(long produtoId){
        return cadastroEstoque.listarEstoquesPorProdutoId(produtoId);
    }

    public List<Estoque> listarEstoquesPorArmazem(long armazemId){
        return cadastroEstoque.listarEstoquesPorArmazem(armazemId);
    }
   

}
