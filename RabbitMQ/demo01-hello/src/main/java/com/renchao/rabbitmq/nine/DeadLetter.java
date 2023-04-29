package com.renchao.rabbitmq.nine;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.renchao.rabbitmq.utils.RabbitInfo;
import com.renchao.rabbitmq.utils.RabbitMqUtils;

public class DeadLetter {
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        DeliverCallback deliverCallback = (consumerTag, message) -> System.out.println(new String(message.getBody()));

        channel.basicConsume(RabbitInfo.D_QUEUE,true,deliverCallback,consumerTag -> {});
    }
}
