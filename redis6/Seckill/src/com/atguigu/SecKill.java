package com.atguigu;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.io.IOException;
import java.util.List;

public class SecKill {

    public static boolean doSecKill(String uid, String prodid) throws IOException {

        if (uid == null || prodid == null) {
            return false;
        }

        Jedis jedis = JedisPoolUtil.getJedisPoolInstance().getResource();

//        Jedis jedis = new Jedis("192.168.123.89", 6379);



        jedis.watch(prodid);

        if (Integer.parseInt(jedis.get(prodid)) <= 0) {
            System.out.println("失败");
            jedis.close();
            return false;
        }

        Transaction multi = jedis.multi();

        multi.decr(prodid);

        List<Object> exec = multi.exec();

        if (exec == null || exec.size() == 0) {
            jedis.close();
            return doSecKill(uid, prodid);
//            return false;
        }
        jedis.lpush("user", uid);

        jedis.close();
        System.out.println("秒杀成功。。。。");
        return true;
    }
}
