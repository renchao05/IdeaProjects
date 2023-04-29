package com.renchao.rabbitmq.six;

import com.rabbitmq.client.Channel;
import com.renchao.rabbitmq.utils.RabbitMqUtils;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EmitLogDirect {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("请输入消息：");
            String message = scanner.nextLine();
            System.out.print("请输入绑定类型：");
            String binding = scanner.nextLine();
            channel.basicPublish(EXCHANGE_NAME, binding, null, message.getBytes(StandardCharsets.UTF_8));
        }
    }
}
