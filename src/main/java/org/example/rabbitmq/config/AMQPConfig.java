package org.example.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AMQPConfig {

    public static final String EXCHANGE_NAME = "Cards";
    public static final String QUEUE = "cards-created";
    public static final String ROUTING_KEY = "";

    @Bean
    public Exchange declareExchange() {
        return ExchangeBuilder
                .directExchange(EXCHANGE_NAME)
                .durable(true)
                .build();
    }

    @Bean
    public Queue declareQueue() {
        return QueueBuilder.durable(QUEUE).build();
    }

    @Bean
    public Binding declareBinding(Exchange exchange, Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(ROUTING_KEY)
                .noargs();
    }

}
