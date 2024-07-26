package br.edu.ufage.topicos.preco.basica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Data
public class Politica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private String tipo;
    private LocalDateTime dataComeco;
    private LocalDateTime dataFim;
    private int prioridade;
    private boolean ativa;
}
