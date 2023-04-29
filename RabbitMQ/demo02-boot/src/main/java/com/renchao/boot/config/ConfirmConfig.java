package com.renchao.boot.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConfirmConfig {
    public static final String CONFIRM_QUEUE = "confirm.queue";
    public static final String CONFIRM_EXCHANGE = "confirm.exchange";
    public static final String BACKUP_EXCHANGE = "backup.exchange";
    public static final String BACKUP_QUEUE = "backup.queue";
    public static final String WARNING_QUEUE = "warning.queue";

    // 声明交换机====添加备份交换机==============
    @Bean
    public DirectExchange confirmExchange() {
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("alternate-exchange", BACKUP_EXCHANGE);
        return new DirectExchange(CONFIRM_EXCHANGE,false,false,arguments);
    }

    // 声明队列
    @Bean
    public Queue confirmQueue() {
        return QueueBuilder.durable(CONFIRM_QUEUE).build();
    }

    // 绑定队列到交换机
    @Bean
    public Binding confirmQueueBinding(Queue confirmQueue, DirectExchange confirmExchange) {
        return BindingBuilder.bind(confirmQueue).to(confirmExchange).with("key1");
    }

    // 下面是备份交换机配置===================================================
    // 声明备份交换机
    @Bean
    public FanoutExchange backupExchange() {
        return new FanoutExchange(BACKUP_EXCHANGE);
    }

    // 声明备份队列
    @Bean
    public Queue backupQueue() {
        return new Queue(BACKUP_QUEUE);
    }

    // 绑定备份队列到备份交换机
    @Bean
    public Binding backupQueueToBackupExchange(Queue backupQueue, FanoutExchange backupExchange) {
        return BindingBuilder.bind(backupQueue).to(backupExchange);
    }

    // 声明警告队列
    @Bean
    public Queue warningQueue() {
        return new Queue(WARNING_QUEUE);
    }

    // 绑定警告队列到备份交换机
    @Bean
    public Binding warningQueueToBackupExchange(Queue warningQueue, FanoutExchange backupExchange) {
        return BindingBuilder.bind(warningQueue).to(backupExchange);
    }
}
