package com.renchao.boot.config;

import com.renchao.boot.utils.RabbitInfo;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

import static com.renchao.boot.utils.RabbitInfo.*;


@Configuration
public class TtlQueueConfig {

    /**
     * 声明 X 交换机
     */
    @Bean
    public DirectExchange xExchange() {
        return new DirectExchange(X_EXCHANGE);
    }

    /**
     * 声明 Y 交换机
     */
    @Bean
    public DirectExchange yExchange() {
        return new DirectExchange(Y_EXCHANGE);
    }


    /**
     * 声明死信队列 D
     */
    @Bean
    public Queue queueD() {
        return new Queue(D_QUEUE);
    }

    /**
     * 死信队列 D 绑定到 Y 交换机
     */
    @Bean
    public Binding deadLetter(Queue queueD,DirectExchange yExchange) {
        return BindingBuilder.bind(queueD).to(yExchange).with("YD");
    }

    /**
     * 声明队列 A
     */
    @Bean
    public Queue queueA() {
        HashMap<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", Y_EXCHANGE);
        args.put("x-dead-letter-routing-key", "YD");
        args.put("x-message-ttl", 10000);
        return QueueBuilder.durable(A_QUEUE).withArguments(args).build();
    }

    /**
     * 声明队列 B
     */
    @Bean
    public Queue queueB() {
        HashMap<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", Y_EXCHANGE);
        args.put("x-dead-letter-routing-key", "YD");
        args.put("x-message-ttl", 40000);
        return QueueBuilder.durable(B_QUEUE).withArguments(args).build();
    }

    /**
     * 声明队列 C
     */
    @Bean
    public Queue queueC() {
        HashMap<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", Y_EXCHANGE);
        args.put("x-dead-letter-routing-key", "YD");
        return QueueBuilder.durable(C_QUEUE).withArguments(args).build();
    }


    /**
     * 队列 A 绑定到 X 交换机
     */
    @Bean
    public Binding queueABindingX(Queue queueA, DirectExchange xExchange) {
        return BindingBuilder.bind(queueA).to(xExchange).with("XA");
    }

    /**
     * 队列 B 绑定到 X 交换机
     */
    @Bean
    public Binding queueBBindingX(Queue queueB, DirectExchange xExchange) {
        return BindingBuilder.bind(queueB).to(xExchange).with("XB");
    }

    /**
     * 队列 B 绑定到 X 交换机
     */
    @Bean
    public Binding queueCBindingX(Queue queueC, DirectExchange xExchange) {
        return BindingBuilder.bind(queueC).to(xExchange).with("XC");
    }
}
