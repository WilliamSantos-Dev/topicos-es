package br.edu.ufage.topicos.preco.controlador.resposta;

import br.edu.ufage.topicos.preco.basica.Politica;

public class PoliticaResponse {

    private Long id;
    private String nome;

    public PoliticaResponse(Politica politica) {
        this.id = politica.getId();
        this.nome = politica.getNome();
    }

}
