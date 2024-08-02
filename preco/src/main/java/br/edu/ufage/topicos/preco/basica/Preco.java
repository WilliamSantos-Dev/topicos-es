package br.edu.ufage.topicos.preco.basica;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

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
}
