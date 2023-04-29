package com.renchao.rabbitmq.five;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.renchao.rabbitmq.utils.RabbitMqUtils;

public class ReceiveLogs02 {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue, EXCHANGE_NAME, "");

        System.out.println("等待接收消息，把消息写入磁盘。。。。。。");
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("数据写入磁盘成功：：" + new String(message.getBody()));
        };
        channel.basicConsume(queue, true, deliverCallback, consumerTag -> {});
    }
}
