package com.renchao.boot.consumer;

import com.renchao.boot.config.ConfirmConfig;
import com.renchao.boot.config.PriorityConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PriorityConsumer {

    @RabbitListener(queues = PriorityConfig.HELLO_QUEUE)
    public void receiveMsg(Message message) {
        log.info("接收到队列的消息：{}", new String(message.getBody()));
    }
}
