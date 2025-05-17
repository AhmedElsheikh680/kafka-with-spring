package com.spring.order.controller;


import com.spring.order.model.Order;
import com.spring.order.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/create-order")
    public ResponseEntity<?> sendMessage(@RequestParam("name") String name , @RequestParam("price") int price) {
//        Map<String, Integer> orders= new HashMap<String, Integer>();
//        orders.put(name, price);
        Order order = new Order(name, price);

        return ResponseEntity.ok(producerService.sendMessage(order));
    }
}
