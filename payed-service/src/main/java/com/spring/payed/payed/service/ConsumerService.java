package com.spring.payed.payed.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {


    @KafkaListener(topics="${kafka-topic}")
    public void comsumeMessage(Message message) {
        System.out.println("Message Sent Successfully!!!!!!! "+ message.getPayload());

    }
}
