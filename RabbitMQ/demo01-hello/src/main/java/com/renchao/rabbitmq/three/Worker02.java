package com.renchao.rabbitmq.three;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.renchao.rabbitmq.utils.RabbitMqUtils;
import com.renchao.rabbitmq.utils.SleepUtils;

public class Worker02 {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {

        Channel channel = RabbitMqUtils.getChannel();

        int prefetchCount = 1;
        channel.basicQos(prefetchCount);

        System.out.println("C1等待接受消息。。。。");

        // 推送的消息如何进行消费的接口回调
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//            SleepUtils.sleep(1);
            System.out.println(new String(delivery.getBody()));
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        };
        //取消消费的一个回调接口 如在消费的时候队列被删除掉了
        CancelCallback cancelCallback = consumerTag -> System.out.println("消息消费被中断了");

        channel.basicConsume(QUEUE_NAME, false, deliverCallback, cancelCallback);
    }
}
