package org.example.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static org.example.rabbitmq.config.AMQPConfigUtil.MARKETING_QUEUE;

@Component
public class CardMarketingListener {

    @RabbitListener(queues = MARKETING_QUEUE)
    public void consumer(String message) {
        System.out.println("Marketing listener: " + message);
    }

}
