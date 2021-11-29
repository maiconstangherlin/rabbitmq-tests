package org.example.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import static org.example.rabbitmq.config.AMQPConfigUtil.*;

//@Configuration
public class AMQPConfigHeaderExchange {

    @Bean
    public HeadersExchange declareExchange() {
        return ExchangeBuilder
                .headersExchange(EXCHANGE_NAME)
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
    public Binding marketingBinding(HeadersExchange exchange, @Qualifier("marketingQueue") Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .where("departament")
                .matches("marketing");
    }

    @Bean
    public Binding financeBinding(HeadersExchange exchange, @Qualifier("financeQueue") Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .where("departament")
                .matches("finance");
    }

}
