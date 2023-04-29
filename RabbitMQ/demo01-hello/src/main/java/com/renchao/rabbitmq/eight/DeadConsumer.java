package com.renchao.rabbitmq.eight;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.renchao.rabbitmq.utils.RabbitInfo;
import com.renchao.rabbitmq.utils.RabbitMqUtils;

public class DeadConsumer {
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        System.out.println("准备接收死信消息。。。。");
        DeliverCallback deliverCallback = (consumerTag, message) -> System.out.println(new String(message.getBody()));
        channel.basicConsume(RabbitInfo.DEAD_QUEUE,true,deliverCallback, consumerTag -> {});
    }
}
