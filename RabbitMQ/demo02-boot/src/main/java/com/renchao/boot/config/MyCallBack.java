package com.renchao.boot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
public class MyCallBack implements RabbitTemplate.ConfirmCallback ,RabbitTemplate.ReturnsCallback {
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        String id = "";
        String message = "";
        if (correlationData != null) {
            id = correlationData.getId();
            message = new String(Objects.requireNonNull(correlationData.getReturnedMessage()).getBody());
        }
        if (b) {
            log.info("交换机收到id为{}的消息:{}", id,message);
        } else {
            log.info("交换机还未收到id为{}的消息:{}，原因是：{}",id,message,s);
        }
    }

//    @Override
//    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
//        log.error("消息{},被交换机{}退回，退回原因:{},路由key:{}",
//                new String(message.getBody()),s,s1,s2);
//    }

    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        log.error("消息【{}】,被交换机【{}】退回，退回原因:【{}】,路由key:【{}】",
                new String(returnedMessage.getMessage().getBody()),
                returnedMessage.getExchange(),
                returnedMessage.getReplyText(),
                returnedMessage.getRoutingKey());

//        log.info("ReplyCode的值是：{}",returnedMessage.getReplyCode());
    }
}
