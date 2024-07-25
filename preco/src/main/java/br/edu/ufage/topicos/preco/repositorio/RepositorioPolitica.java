package br.edu.ufage.topicos.preco.repositorio;

import br.edu.ufage.topicos.preco.basica.Politica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioPolitica extends JpaRepository<Politica, Long> {
    List<Politica> findByTipoContainingIgnoreCase(String tipo);
}
