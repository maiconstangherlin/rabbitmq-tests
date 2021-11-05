package org.example.rabbitmq.listener;

import org.example.rabbitmq.config.AMQPConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CardListener {

    @RabbitListener(queues = AMQPConfig.QUEUE)
    public void consumer(String message) {

    }

}
