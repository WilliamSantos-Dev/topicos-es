package br.edu.ufage.topicos.catalogo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CatalogoRabbitMQConsumer {

    @RabbitListener(queues = "catalogoQueue")
    public void consumeMessage(String message) {
        log.info("Received message from catalogoQueue: {}", message);
    }
}
