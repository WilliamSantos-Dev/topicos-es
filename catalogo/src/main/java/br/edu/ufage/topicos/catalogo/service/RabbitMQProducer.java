package br.edu.ufage.topicos.catalogo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessageToCategoriaQueue(String message) {
        rabbitTemplate.convertAndSend("categoriaQueue", message);
        log.info("Message sent to categoriaQueue: {}", message);
    }

    public void sendMessageToProdutoQueue(String message) {
        rabbitTemplate.convertAndSend("produtoQueue", message);
        log.info("Message sent to produtoQueue: {}", message);
    }
}