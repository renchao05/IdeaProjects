package com.renchao.rabbitmq.eight;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.renchao.rabbitmq.utils.RabbitInfo;
import com.renchao.rabbitmq.utils.RabbitMqUtils;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static com.renchao.rabbitmq.utils.RabbitInfo.NORMAL_EXCHANGE;

public class ProducerTTL {
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        // 过期时间
        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().expiration("10000").build();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入消息：");
            String message = scanner.next();
            channel.basicPublish(NORMAL_EXCHANGE,"zhangsan",properties,message.getBytes(StandardCharsets.UTF_8));
        }
    }
}
