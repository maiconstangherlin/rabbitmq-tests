package org.example.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import static org.example.rabbitmq.config.AMQPConfigUtil.*;

//@Configuration
public class AMQPConfigDirect {

    @Bean
    public Exchange declareExchange() {
        return ExchangeBuilder
                .directExchange(EXCHANGE_NAME)
                .durable(true)
                .build();
    }

    @Bean
    public Queue marketingQueue() {
        return QueueBuilder.durable(MARKETING_QUEUE).build();
    }

    @Bean
    public Queue financeQueue() {
        return QueueBuilder.durable(FINANCE_QUEUE).build();
    }

    @Bean
    public Binding marketingBinding(Exchange exchange, @Qualifier("marketingQueue") Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(ROUTING_KEY)
                .noargs();
    }

    @Bean
    public Binding financeBinding(Exchange exchange, @Qualifier("financeQueue") Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(ROUTING_KEY)
                .noargs();
    }

}
