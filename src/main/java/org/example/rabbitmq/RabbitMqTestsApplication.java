package org.example.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
//@EnableWebSocket
@SpringBootApplication
//@EnableWebSocketMessageBroker
public class RabbitMqTestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqTestsApplication.class, args);
    }

}
