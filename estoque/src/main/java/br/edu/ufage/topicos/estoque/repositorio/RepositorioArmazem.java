package br.edu.ufage.topicos.estoque.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufage.topicos.estoque.basica.Armazem;

public interface RepositorioArmazem extends JpaRepository<Armazem, Long> {
    List<Armazem> findByNomeContainingIgnoreCase(String nome);
}
