package com.renchao.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class TestRedisController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/redis")
    public String testRedis(@RequestParam("name") String name) {

        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        operations.set("user", name);

        return operations.get("user");
    }

    @GetMapping("testLock")
    public void testLock(){
        String uuid = UUID.randomUUID().toString();
        //1获取锁，setne
        Boolean lock = redisTemplate.opsForValue().setIfAbsent("lock", uuid,3, TimeUnit.SECONDS);
//        System.out.println(lock);
        //2获取锁成功、查询num的值
        if(Boolean.TRUE.equals(lock)){
            Object value = redisTemplate.opsForValue().get("num");
            //2.1判断num为空return
            if(StringUtils.isEmpty(value)){
                // 返回前，释放锁，del
                redisTemplate.delete("lock");
                return;
            }
            //2.2有值就转成成int
            int num = Integer.parseInt(value+"");
            //2.3把redis的num加1
            redisTemplate.opsForValue().set("num", String.valueOf(++num));
            //2.4释放锁，del
            if (uuid.equals(redisTemplate.opsForValue().get(uuid))) {
                redisTemplate.delete("lock");
            }
        }else{
            //3获取锁失败、每隔0.1秒再获取
            try {
                Thread.sleep(50);
                testLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
