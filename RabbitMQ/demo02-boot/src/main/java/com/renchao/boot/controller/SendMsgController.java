package com.renchao.boot.controller;


import com.renchao.boot.utils.RabbitInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static com.renchao.boot.utils.RabbitInfo.DELAYED_ROUTING_KEY;

@Slf4j
@RestController
public class SendMsgController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/sendMsg/{message}")
    public void sendMsg(@PathVariable("message") String message) {
        log.info("当前时间：{},发送一条信息给两个TTL队列：{}", new Date(), message);
        rabbitTemplate.convertAndSend(RabbitInfo.X_EXCHANGE, "XB", "消息来自ttl为30s的队列：" + message);
        rabbitTemplate.convertAndSend(RabbitInfo.X_EXCHANGE, "XA", "消息来自ttl为10s的队列：" + message);
    }

    @RequestMapping("/sendMsg/{message}/{ttlTime}")
    public void sendMsgTTL(@PathVariable("message") String message,
                           @PathVariable("ttlTime") String ttlTime) {
        log.info("当前时间：{},发送一条时长 {} 的信息给TTL队列：{}", new Date(), ttlTime, message);

        rabbitTemplate.convertAndSend(RabbitInfo.X_EXCHANGE, "XC", message, correlationData -> {
            correlationData.getMessageProperties().setExpiration(ttlTime);
            return correlationData;
        });
    }

    @RequestMapping("/sendMsgPlugin/{message}/{ttlTime}")
    public void sendMsgTTLPlugin(@PathVariable("message") String message,
                           @PathVariable("ttlTime") Integer ttlTime) {
        log.info("当前时间：{},发送一条时长 {} 的信息给TTL队列：{}", new Date(), ttlTime, message);

        rabbitTemplate.convertAndSend(RabbitInfo.DELAYED_EXCHANGE_NAME, DELAYED_ROUTING_KEY, message, correlationData -> {
            correlationData.getMessageProperties().setDelay(ttlTime);
            return correlationData;
        });
    }
}
