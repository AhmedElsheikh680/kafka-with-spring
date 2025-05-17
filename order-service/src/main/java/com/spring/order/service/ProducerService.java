package com.spring.order.service;


import com.spring.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProducerService {


    private String topic;
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @Value("${kafka-topic}")
    private String topicName;

    public String sendMessage(Order order) {
//        return String.valueOf(kafkaTemplate.send(topicName, String.valueOf(new Order(order.getName(), order.getPrice()))));
//        return kafkaTemplate.send(topicName, order);
        kafkaTemplate.send(topicName, order);
        return "Order sent to Kafka: " + order.toString();
    }
}
