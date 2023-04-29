package com.renchao.rabbitmq.config;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.renchao.rabbitmq.utils.RabbitInfo;
import com.renchao.rabbitmq.utils.RabbitMqUtils;

import java.util.HashMap;
import java.util.Map;

import static com.renchao.rabbitmq.utils.RabbitInfo.*;

public class DelayQueueConfig {
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare(X_EXCHANGE, BuiltinExchangeType.DIRECT);
        channel.exchangeDeclare(Y_EXCHANGE, BuiltinExchangeType.DIRECT);

        // 声明死信队列
        channel.queueDeclare(D_QUEUE, false, false, false, null);
        channel.queueBind(D_QUEUE, Y_EXCHANGE, "YD");

        // 声明 QA 队列
        Map<String, Object> qaParams = new HashMap<>();
        qaParams.put("x-dead-letter-exchange", Y_EXCHANGE);
        qaParams.put("x-dead-letter-routing-key", "YD");
        qaParams.put("x-message-ttl", 5000);
        channel.queueDeclare(A_QUEUE, false, false, false, qaParams);
        channel.queueBind(A_QUEUE, X_EXCHANGE, "XA");

        // 声明 QB 队列
        Map<String, Object> qbParams = new HashMap<>();
        qbParams.put("x-dead-letter-exchange", Y_EXCHANGE);
        qbParams.put("x-dead-letter-routing-key", "YD");
        qbParams.put("x-message-ttl", 20000);
        channel.queueDeclare(B_QUEUE, false, false, false, qbParams);
        channel.queueBind(B_QUEUE, X_EXCHANGE, "XB");
    }
}
