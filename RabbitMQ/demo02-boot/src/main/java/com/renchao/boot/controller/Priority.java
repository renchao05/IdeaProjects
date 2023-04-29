package com.renchao.boot.controller;

import com.renchao.boot.config.PriorityConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Priority {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/priority")
    public void testPriority() {
        for (int i = 0; i < 30; i++) {
            if (i % 5 == 0) {
                rabbitTemplate.convertAndSend(PriorityConfig.HELLO_EXCHANGE, "", "info" + i, message -> {
                    message.getMessageProperties().setPriority(5);
                    return message;
                });
            } else {
                rabbitTemplate.convertAndSend(PriorityConfig.HELLO_EXCHANGE, "", "info" + i);
            }
        }
    }
}
