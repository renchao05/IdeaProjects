package com.renchao.rabbitmq.four;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.renchao.rabbitmq.utils.RabbitMqUtils;

public class Task04 {
    private final static String QUEUE_NAME = "hello";
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        // 开启发布确认
        channel.confirmSelect();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            String message = i + "";
            channel.basicPublish("", QUEUE_NAME, MessageProperties.MINIMAL_PERSISTENT_BASIC, message.getBytes());
            // 批量确认是否成功
            if (i % 100 == 0) {
                boolean flag = channel.waitForConfirms();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start)); //10000 用时1949
    }
}
