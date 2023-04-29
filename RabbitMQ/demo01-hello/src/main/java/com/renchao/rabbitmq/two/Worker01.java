package com.renchao.rabbitmq.two;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.renchao.rabbitmq.utils.RabbitMqUtils;

public class Worker01 {
    private final static String QUEUE_NAME = "hello";
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        System.out.println("C2等待接受消息。。。。");
        // 推送的消息如何进行消费的接口回调
        DeliverCallback deliverCallback = (consumerTag, delivery) -> System.out.println(new String(delivery.getBody()));
        //取消消费的一个回调接口 如在消费的时候队列被删除掉了
        CancelCallback cancelCallback = consumerTag -> System.out.println("消息消费被中断了");

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}
