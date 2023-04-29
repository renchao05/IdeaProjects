package com.renchao.rabbitmq.one;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer666 {
    private final static String QUEUE_NAME = "fed_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 一、创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.123.167");
        factory.setUsername("admin");
        factory.setPassword("123");

        // 二、创建连接
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        System.out.println("等待接受消息。。。。");

        // 推送的消息如何进行消费的接口回调
        DeliverCallback deliverCallback = (consumerTag, delivery) -> System.out.println(new String(delivery.getBody()));
        //取消消费的一个回调接口 如在消费的时候队列被删除掉了
        CancelCallback cancelCallback = consumerTag -> System.out.println("消息消费被中断了");

        /*
             消费者消费消息
             1.消费哪个队列
             2.消费成功之后是否要自动应答 true 代表自动应答 false 手动应答
             3.消费者未成功消费的回调
         */
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}