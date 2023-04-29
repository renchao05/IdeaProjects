package com.renchao.rabbitmq.five;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.renchao.rabbitmq.utils.RabbitMqUtils;

public class ReceiveLogs6666 {
    private static final String FED_EXCHANGE = "E4";
    private static final String NODE_QUEUE = "Q44";
    private static final String BINDING = "key4";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        // 声明交换机
        channel.exchangeDeclare(FED_EXCHANGE, BuiltinExchangeType.DIRECT);
        // 生成队列
        channel.queueDeclare(NODE_QUEUE,false,false,false,null);
        // 把队列绑定到 exchange 其中 bindingKey 为空字符串
        channel.queueBind(NODE_QUEUE, FED_EXCHANGE, BINDING);
        System.out.println("等待接收消息，把消息打印到屏幕。。。。。。");
        // 处理接收到的消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println(new String(message.getBody()));
        };
        channel.basicConsume(NODE_QUEUE,true,deliverCallback, consumerTag -> {});
    }
}
