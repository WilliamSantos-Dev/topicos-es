package br.edu.ufage.topicos.estoque.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufage.topicos.estoque.basica.Estoque;

public interface RepositorioEstoque extends JpaRepository<Estoque, Long> {
    List<Estoque> findByProdutoId(long produtoId);
    List<Estoque> findByArmazem_id(long armazemId);
    Estoque findByProdutoIdAndArmazem_id(long produtoId, long armazemId);
}
