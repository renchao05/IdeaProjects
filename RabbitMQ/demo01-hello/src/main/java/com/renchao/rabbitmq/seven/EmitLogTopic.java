package com.renchao.rabbitmq.seven;

import com.rabbitmq.client.Channel;
import com.renchao.rabbitmq.utils.RabbitMqUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmitLogTopic {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        Map<String, String> map = new HashMap<>();
        map.put("quick.orange.rabbit", "被队列 Q1Q2 接收到");
        map.put("lazy.orange.elephant", "被队列 Q1Q2 接收到");
        map.put("quick.orange.fox", "被队列 Q1 接收到");
        map.put("lazy.brown.fox", "被队列 Q2 接收到");
        map.put("lazy.pink.rabbit", "虽然满足两个绑定但只被队列 Q2 接收一次");
        map.put("quick.brown.fox", "不匹配任何绑定不会被任何队列接收到会被丢弃");
        map.put("quick.orange.male.rabbit", "是四个单词不匹配任何绑定会被丢弃");
        map.put("lazy.orange.male.rabbit", "是四个单词但匹配 Q2");
        map.forEach((k,v) -> {
            try {
                channel.basicPublish(EXCHANGE_NAME,k,null,v.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
