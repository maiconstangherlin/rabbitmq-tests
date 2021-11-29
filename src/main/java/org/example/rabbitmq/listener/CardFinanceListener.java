package org.example.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static org.example.rabbitmq.config.AMQPConfigUtil.FINANCE_QUEUE;

@Component
public class CardFinanceListener {

    @RabbitListener(queues = FINANCE_QUEUE)
    public void consumer(String message) {
        System.out.println("Finance listener: " + message);
    }

}
