package com.renchao.boot.controller;

import com.renchao.boot.config.ConfirmConfig;
import com.renchao.boot.config.MyCallBack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@Slf4j
@RestController
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate,MyCallBack myCallBack) {
        this.rabbitTemplate = rabbitTemplate;
        // 开启当消息传递过程中不可达目的地时将消息返回给生产者
        this.rabbitTemplate.setMandatory(true);
        // 注入 Mandatory 功能的回调接口
        this.rabbitTemplate.setReturnsCallback(myCallBack);
//        this.rabbitTemplate.setConfirmCallback(myCallBack);
    }

    @GetMapping("/sendMessage/{message}")
    public void sendMessage(@PathVariable String message) {
        CorrelationData correlationData1 = new CorrelationData("11");
        Message message1 = new Message(message.getBytes(StandardCharsets.UTF_8), null);
        correlationData1.setReturnedMessage(message1);
        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE, "key1", message.getBytes(StandardCharsets.UTF_8),correlationData1);
        CorrelationData correlationData2 = new CorrelationData("22");
        correlationData2.setReturnedMessage(message1);
        // 发送时交换机加上123后缀，模拟交换机出现问题
        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE, "key2", message.getBytes(StandardCharsets.UTF_8),correlationData2);
    }

    @GetMapping("/sendMessage")
    public void bakSendMessage() {
        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE, "key1", "message1".getBytes());
        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE, "key2", "message2".getBytes());
    }



}
