package org.example.rabbitmq.listener;

import org.example.rabbitmq.config.AMQPConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Card {

    @RabbitListener(queues = AMQPConfig.QUEUE)
    public void consumer(String message) {

    }

}
