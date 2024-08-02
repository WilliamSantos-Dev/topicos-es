package br.edu.ufage.topicos.preco.controlador.resposta;

import br.edu.ufage.topicos.preco.basica.Preco;

public class PrecoResponse {

    private Long id;
    private Double valor;
    private String produto;

    public PrecoResponse(Preco preco) {
        this.id = preco.getId();
    }


}
