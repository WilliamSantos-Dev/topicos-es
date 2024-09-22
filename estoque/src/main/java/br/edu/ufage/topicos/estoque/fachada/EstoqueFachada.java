package br.edu.ufage.topicos.estoque.fachada;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ufage.topicos.estoque.basica.Armazem;
import br.edu.ufage.topicos.estoque.basica.Estoque;
import br.edu.ufage.topicos.estoque.cadastro.Exceptions.ArmazemNaoEncontradoException;
import br.edu.ufage.topicos.estoque.cadastro.InterfaceCadastroArmazem;
import br.edu.ufage.topicos.estoque.cadastro.InterfaceCadastroEstoque;
import br.edu.ufage.topicos.estoque.controlador.requesicao.EstoqueRequest;
import br.edu.ufage.topicos.estoque.fachada.exceção.EstoqueNaoEncontradoException;
import br.edu.ufage.topicos.estoque.fachada.exceção.ProdutoDuplicadoException;

@Service
public class EstoqueFachada {
    
    @Autowired
    InterfaceCadastroArmazem cadastroArmazem;

    @Autowired
    InterfaceCadastroEstoque cadastroEstoque;

    public Armazem adicionarArmazem(Armazem entity){
        return cadastroArmazem.salvarArmazem(entity);
    }

    public Armazem atualizarArmazem(Long id, Armazem novoArmazem) throws ArmazemNaoEncontradoException {
        return cadastroArmazem.atualizarArmazem(id, novoArmazem);
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
            throw new ProdutoDuplicadoException("Estoque já existe para o produto e armazém informados");
        }

        return cadastroEstoque.salvarEstoque(entity);
    }

    public void removerEstoque(Long id) throws EstoqueNaoEncontradoException {
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

    public Estoque atualizarEstoque(Long id, EstoqueRequest request) {
        return cadastroEstoque.atualizarEstoque(id, request);
    }

    @Autowired
    private RestTemplate restTemplate;

    public boolean verificarProdutoNoCatalogo(Long produtoId) {
        String url = "http://catalogo:8080/catalogo/produto/" + produtoId;
        
        try {
            ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
            return response.getStatusCode() == HttpStatus.OK;
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return false;  // Produto não encontrado
            }
            throw e;  
        } catch (ResourceAccessException e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Serviço de catálogo não disponível", e);
        }
    }  

}
