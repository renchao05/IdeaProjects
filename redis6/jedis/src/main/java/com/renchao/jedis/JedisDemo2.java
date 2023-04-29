package com.renchao.jedis;

import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.Set;

public class JedisDemo2 {

    public static void main(String[] args) {
        Set<HostAndPort>set =new HashSet<>();
        // 可以多设置几个或者把集群的地址都设置，防止部分宕机
        set.add(new HostAndPort("192.168.123.89",6379));
        set.add(new HostAndPort("192.168.123.89",6380));
        JedisCluster jedisCluster=new JedisCluster(set);

        Long setnx = jedisCluster.setnx("k1", "sss");
        System.out.println(setnx);
    }



    private static JedisSentinelPool jedisSentinelPool=null;

    public static Jedis getJedisFromSentinel(){
        if(jedisSentinelPool==null){
            Set<String> sentinelSet=new HashSet<>();
            // 端口是哨兵的端口
            sentinelSet.add("192.168.123.89:26379");

            JedisPoolConfig jedisPoolConfig =new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10); //最大可用连接数
            jedisPoolConfig.setMaxIdle(5); //最大闲置连接数
            jedisPoolConfig.setMinIdle(5); //最小闲置连接数
            jedisPoolConfig.setBlockWhenExhausted(true); //连接耗尽是否等待
            jedisPoolConfig.setMaxWaitMillis(2000); //等待时间
            jedisPoolConfig.setTestOnBorrow(true); //取连接的时候进行一下测试 ping pong

            jedisSentinelPool=new JedisSentinelPool("mymaster",sentinelSet,jedisPoolConfig);
            return jedisSentinelPool.getResource();
        }else{
            return jedisSentinelPool.getResource();
        }
    }
}
