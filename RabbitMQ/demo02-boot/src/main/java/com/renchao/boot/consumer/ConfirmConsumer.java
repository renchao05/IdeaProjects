package com.renchao.boot.consumer;

import com.renchao.boot.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConfirmConsumer {
    @RabbitListener(queues = ConfirmConfig.CONFIRM_QUEUE)
    public void receiveMsg(Message message) {
        log.info("接收到正常队列的消息：{}", new String(message.getBody()));
    }

    @RabbitListener(queues = ConfirmConfig.WARNING_QUEUE)
    public void warningReceiveMsg(Message message) {
        log.info("接收到【警告】队列的消息：{}", new String(message.getBody()));
    }

    @RabbitListener(queues = ConfirmConfig.BACKUP_QUEUE)
    public void backupReceiveMsg(Message message) {
        log.info("接收到【备份】队列的消息：{}", new String(message.getBody()));
    }


}
