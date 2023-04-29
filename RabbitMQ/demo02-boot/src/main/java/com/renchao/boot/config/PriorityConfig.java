package com.renchao.boot.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PriorityConfig {
    public static final String HELLO_QUEUE = "hello.queue";
    public static final String HELLO_EXCHANGE = "hello.exchange";

    @Bean
    public Queue helloQueue() {
        Map<String, Object> params = new HashMap<>();
        params.put("x-max-priority", 10);
        return new Queue(HELLO_QUEUE, false, false, false, params);
    }

    @Bean
    public DirectExchange helloExchange() {
        return new DirectExchange(HELLO_EXCHANGE);
    }

    @Bean
    public Binding helloToExchange(Queue helloQueue,DirectExchange helloExchange) {
        return BindingBuilder.bind(helloQueue).to(helloExchange).with("");
    }
}
