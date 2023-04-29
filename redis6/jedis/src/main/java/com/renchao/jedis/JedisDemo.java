package com.renchao.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.stream.IntStream;

public class JedisDemo {

    @Test
    public void test00() {
        Jedis jedis = JedisDemo2.getJedisFromSentinel();
        String ping = jedis.ping();
        System.out.println(ping);
        jedis.set("k6", "ccddss");
        String k6 = jedis.get("k6");
        System.out.println(k6);
    }

    @Test
    public void test01() {
        Jedis jedis = new Jedis("192.168.123.89", 6379);

    }

    @Test
    public void test02() {
        SecureRandom random = new SecureRandom();
        for (int k = 0; k < 100; k++) {
            StringBuilder code = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                code.append(random.nextInt(10));
            }
            System.out.println(code);
        }

    }

    public String getCode(String phone) {
        Jedis jedis = new Jedis("192.168.123.89", 6379);
        String phoneCount = "Count." + phone;
        String count = jedis.get(phoneCount);
        if (count == null || Integer.parseInt(count) < 3) {
            jedis.incr(phoneCount);
        } else  {
            return null;
        }
        SecureRandom random = new SecureRandom();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            code.append(random.nextInt(10));
        }
        return code.toString();
    }

    public void saveCode(String code, String phone) {
        Jedis jedis = new Jedis("192.168.123.89", 6379);
        jedis.setex(phone, 120, code);
        jedis.close();
    }

    public boolean equals(String newCode, String phone) {
        Jedis jedis = new Jedis("192.168.123.89", 6379);
        String code = jedis.get(phone);
        return code.equals(newCode);
    }

    @Test
    public void Client() {
        String phone = "13862851174";
        String code = getCode(phone);
        if (code == null) {
            System.out.println("验证次数超限！！！");
            return;
        }
        saveCode(code,phone);
        System.out.println(code);

        String newCode = "123456";

        System.out.println(equals(newCode, phone) ? "验证成功" : "验证失败");
    }



}
