package br.edu.ufage.topicos.preco.basica;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Preco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long produtoId;
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "politica_id")
    private Politica politica;

    public BigDecimal getPreco() {
        return preco;
    }
}
