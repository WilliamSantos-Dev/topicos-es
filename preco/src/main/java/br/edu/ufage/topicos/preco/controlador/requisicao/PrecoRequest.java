package br.edu.ufage.topicos.preco.controlador.requisicao;

public class PrecoRequest {
    private Double valor;
    private String produto;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}
