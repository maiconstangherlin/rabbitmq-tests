package org.example.rabbitmq.controllers;

import lombok.RequiredArgsConstructor;
import org.example.rabbitmq.producer.CardProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/card")
@RequiredArgsConstructor
public class CardController {

    private final CardProducer cardProducer;

    @GetMapping
    public String card() {
        return "OK";
    }

    @PostMapping
    public void sendMessage() {
        cardProducer.sendCards();
    }

}
