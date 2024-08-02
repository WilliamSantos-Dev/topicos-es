package br.edu.ufage.topicos.preco.cadastro;

import java.util.List;

import br.edu.ufage.topicos.preco.basica.Politica;

public interface InterfaceCadastroPolitica {
    List<Politica> listarPoliticas();
    Politica obterPoliticaPorId(Long id);
    Politica salvarPolitica(Politica politica);
    void apagarPolitica(Long id);
}
