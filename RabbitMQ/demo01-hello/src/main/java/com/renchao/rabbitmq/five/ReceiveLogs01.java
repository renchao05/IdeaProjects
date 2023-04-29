package com.renchao.rabbitmq.five;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.renchao.rabbitmq.utils.RabbitMqUtils;

public class ReceiveLogs01 {
    private static final String EXCHANGE_NAME = "logs";
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        // 声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        // 生成临时队列
        String queueName = channel.queueDeclare().getQueue();
        // 把临时队列绑定到 exchange 其中 bindingKey 为空字符串
        channel.queueBind(queueName, EXCHANGE_NAME, "");
        System.out.println("等待接收消息，把消息打印到屏幕。。。。。。");
        // 处理接收到的消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println(new String(message.getBody()));
        };
        channel.basicConsume(queueName,true,deliverCallback,consumerTag -> {});
    }
}
