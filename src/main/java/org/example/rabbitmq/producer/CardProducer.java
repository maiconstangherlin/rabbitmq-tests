package org.example.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static org.example.rabbitmq.config.AMQPConfigUtil.EXCHANGE_NAME;

@Component
public class CardProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendCards() {
        try {
            var message = "Card criado " + LocalDate.now().toString();
            rabbitTemplate.convertAndSend(EXCHANGE_NAME, "", message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
