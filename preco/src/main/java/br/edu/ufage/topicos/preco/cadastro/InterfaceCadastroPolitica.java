package br.edu.ufage.topicos.preco.cadastro;

import br.edu.ufage.topicos.preco.basica.Politica;

import java.util.List;
import java.util.Optional;

public interface InterfaceCadastroPolitica {
    List<Politica> listarPoliticasPorTipo(String tipo);
    Politica salvarPolitica(Politica entity);
    List<Politica> listarPoliticas();
    Optional<Politica> encontrarPolitica(Long id);
    void apagarPolitica(Long id);
    void apagarPolitica(Politica entity);
}
