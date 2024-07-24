package br.edu.ufage.topicos.estoque.cadastro;

import java.util.List;
import java.util.Optional;

import br.edu.ufage.topicos.estoque.basica.Armazem;

public interface InterfaceCadastroArmazem {

    List<Armazem> listarArmazensPorNome(String nome);

    Armazem salvarArmazem(Armazem entity);

    List<Armazem> listarArmazens();

    Optional<Armazem> encontrarArmazemId(Long id);

    void apagarArmazem(Long id);

    void apagarArmazem(Armazem entity);
}
