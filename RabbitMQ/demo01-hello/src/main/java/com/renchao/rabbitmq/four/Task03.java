package com.renchao.rabbitmq.four;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.renchao.rabbitmq.utils.RabbitMqUtils;

import java.io.IOException;
import java.util.Scanner;

public class Task03 {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        // 开启发布确认
        channel.confirmSelect();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            String message = i + "";
            channel.basicPublish("", QUEUE_NAME, MessageProperties.MINIMAL_PERSISTENT_BASIC, message.getBytes());
            // 确认是否成功
            boolean flag = channel.waitForConfirms();
            if (flag) {
                System.out.println("消息发送成功。。");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start)); //10000 用时：12557
    }
}
