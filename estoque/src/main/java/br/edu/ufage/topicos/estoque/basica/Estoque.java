package br.edu.ufage.topicos.estoque.basica;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Estoque {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long produtoId;
    private int quantidade;
    
    @ManyToOne
    @JoinColumn(name = "armazem_id")
    private Armazem armazem;

}