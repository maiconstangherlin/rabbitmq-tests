package org.example.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.example.rabbitmq.config.AMQPConfigUtil.*;

@Configuration
public class AMQPConfigTopic {

    @Bean
    public TopicExchange declareExchange() {
        return ExchangeBuilder
                .topicExchange(EXCHANGE_NAME)
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
    public Queue allQueue() {
        return QueueBuilder.durable(ALL_QUEUE).build();
    }

    @Bean
    public Binding marketingBinding(TopicExchange exchange, @Qualifier("marketingQueue") Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(MARKETING_ROUTING_KEY);
    }

    @Bean
    public Binding financeBinding(TopicExchange exchange, @Qualifier("financeQueue") Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(FINANCE_ROUTING_KEY);
    }

    @Bean
    public Binding allBinding(TopicExchange exchange, @Qualifier("allQueue") Queue queue) {
        return BindingBuilder.bind(queue)
                .to(exchange)
                .with(ALL_ROUTING_KEY);
    }

}
