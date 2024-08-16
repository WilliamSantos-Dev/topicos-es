package br.edu.ufage.topicos.estoque.message;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.edu.ufage.topicos.estoque.basica.Estoque;
import br.edu.ufage.topicos.estoque.repositorio.RepositorioEstoque;

@Configuration
public class MessageProcessor {

    @Autowired
    private RepositorioEstoque repositorioEstoque;

    @Bean
    public Consumer<Event<Long, Integer>> consumeMessage() {
        return e -> {
            switch (e.getType()) {
                case CREATE:
                    System.out.println(e);
                    Estoque estoque = new Estoque();
                    estoque.setProdutoId(e.getKey());
                    estoque.setArmazem(null);
                    repositorioEstoque.save(estoque);
                    break;

                default:
                    break;
            }
        };
    }
}
