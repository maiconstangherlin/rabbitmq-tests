package org.example.rabbitmq.producer;

import org.example.rabbitmq.config.AMQPConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CardProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendCards() {
        try {
            var message = "Card criado " + LocalDate.now().toString();
            rabbitTemplate.convertAndSend(AMQPConfig.EXCHANGE_NAME, "", message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
