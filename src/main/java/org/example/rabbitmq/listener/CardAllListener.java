package org.example.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static org.example.rabbitmq.config.AMQPConfigUtil.ALL_QUEUE;

@Component
public class CardAllListener {

    @RabbitListener(queues = ALL_QUEUE)
    public void consumer(String message) {
        System.out.println("All listener: " + message);
    }

}
