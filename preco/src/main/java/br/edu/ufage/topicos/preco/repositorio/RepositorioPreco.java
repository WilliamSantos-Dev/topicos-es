package br.edu.ufage.topicos.preco.repositorio;

import br.edu.ufage.topicos.preco.basica.Preco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioPreco extends JpaRepository<Preco, Long> {
    List<Preco> findByProdutoId(Long id);
    List<Preco> findByPolitica_id(Long id);
}
