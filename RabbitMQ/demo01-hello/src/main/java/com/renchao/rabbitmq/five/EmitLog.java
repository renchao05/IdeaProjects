package com.renchao.rabbitmq.five;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.renchao.rabbitmq.utils.RabbitMqUtils;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EmitLog {
    private static final String EXCHANGE_NAME = "E1";
    private static final String BINDING = "key4";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入信息：");
            String message = scanner.nextLine();
            channel.basicPublish(EXCHANGE_NAME, BINDING, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("生产者发出消息：" + message);
        }
    }
}
