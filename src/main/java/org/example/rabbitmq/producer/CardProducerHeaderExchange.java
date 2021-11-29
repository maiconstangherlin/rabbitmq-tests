package org.example.rabbitmq.producer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static org.example.rabbitmq.config.AMQPConfigUtil.EXCHANGE_NAME;

@Component
public class CardProducerHeaderExchange {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendCards(String departament) {
        try {
            MessageProperties messageProperties = new MessageProperties();
            messageProperties.setHeader("departament", departament);
            String textMessage = "Card criado " + LocalDate.now().toString();
            Message message = new SimpleMessageConverter().toMessage(textMessage, messageProperties);

            rabbitTemplate.convertAndSend(EXCHANGE_NAME, "", message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
