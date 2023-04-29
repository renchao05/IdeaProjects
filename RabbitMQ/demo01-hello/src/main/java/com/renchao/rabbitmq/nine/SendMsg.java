package com.renchao.rabbitmq.nine;

import com.rabbitmq.client.Channel;
import com.renchao.rabbitmq.utils.RabbitInfo;
import com.renchao.rabbitmq.utils.RabbitMqUtils;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SendMsg {
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("请输入消息：");
            String message = scanner.nextLine();
            System.out.print("请输入绑定哪个队列：");
            String binding = scanner.nextLine();
            channel.basicPublish(RabbitInfo.X_EXCHANGE, binding, null, message.getBytes(StandardCharsets.UTF_8));
        }
    }
}
