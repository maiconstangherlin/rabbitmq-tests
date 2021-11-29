package org.example.rabbitmq.controllers;

import lombok.RequiredArgsConstructor;
import org.example.rabbitmq.producer.CardProducer;
import org.example.rabbitmq.producer.CardProducerHeaderExchange;
import org.example.rabbitmq.producer.CardProducerTopic;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/card")
@RequiredArgsConstructor
public class CardController {

    private final CardProducer cardProducer;
    private final CardProducerHeaderExchange cardProducerHeaderExchange;
    private final CardProducerTopic cardProducerTopic;

    @GetMapping
    public String card() {
        return "OK";
    }

    @PostMapping
    public void sendMessage() {
        cardProducer.sendCards();
    }

    @PostMapping(path = "/header/{routingKey}")
    public void sendMessageTopic(@PathVariable String routingKey) {
        cardProducerTopic.sendCards(routingKey);
    }

    @PostMapping(path = "/header/{departament}")
    public void sendMessageHeaderExchange(@PathVariable String departament) {
        cardProducerHeaderExchange.sendCards(departament);
    }

}
