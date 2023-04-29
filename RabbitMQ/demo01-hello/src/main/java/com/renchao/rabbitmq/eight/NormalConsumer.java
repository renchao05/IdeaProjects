package com.renchao.rabbitmq.eight;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.renchao.rabbitmq.utils.RabbitMqUtils;
import com.renchao.rabbitmq.utils.SleepUtils;


import static com.renchao.rabbitmq.utils.RabbitInfo.NORMAL_QUEUE;

public class NormalConsumer {


    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        System.out.println("等待接收消息。。。。");
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            String m = new String(message.getBody());
//            if (m.contains("5")) {
//                System.out.println("不符合要求，已经拒绝处理。。");
//                channel.basicReject(message.getEnvelope().getDeliveryTag(), false);
//            } else {
//                System.out.println(m);
                channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
//            }
            System.out.println(m);
            SleepUtils.sleep(60);
        };
        channel.basicConsume(NORMAL_QUEUE, false, deliverCallback, consumerTag -> {});
    }
}
