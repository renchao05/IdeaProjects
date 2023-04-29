package com.renchao.rabbitmq.three;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.renchao.rabbitmq.utils.RabbitMqUtils;

import java.util.Scanner;

public class Task02 {
    private final static String QUEUE_NAME = "hello";
    public static void main(String[] args) throws Exception {

        Channel channel = RabbitMqUtils.getChannel();

        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String message = scanner.next();
            channel.basicPublish("", QUEUE_NAME, MessageProperties.MINIMAL_PERSISTENT_BASIC, message.getBytes());
            System.out.println(message + " 发送完毕！");
        }
    }
}
