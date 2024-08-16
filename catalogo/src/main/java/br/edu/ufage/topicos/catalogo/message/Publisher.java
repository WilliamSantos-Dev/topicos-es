package br.edu.ufage.topicos.catalogo.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    @Autowired
    private StreamBridge streamBridge;

    public void sendEvent(Event event) {
        sendMessage("product-out-0", event);
        System.out.println("Sent event: " + event);
    }

    private void sendMessage(String bindingName, Event<Integer, Long> ev) {
        Message message = MessageBuilder.withPayload(ev)
                .setHeader("partitionKey", ev.getKey()).build();
        streamBridge.send(bindingName, message);
    }

}
