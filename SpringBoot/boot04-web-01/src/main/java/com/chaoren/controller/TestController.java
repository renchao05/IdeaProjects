package com.chaoren.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.lang.Comparable;

@RestController
public class TestController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @RequestMapping("/hello")
    public String demo01() {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("k5","v55");
        String v5 = operations.get("k5");
        return "第一个测试。。。" + v5;
    }


    @RequestMapping("/index")
    public String index() {
        return "这个是首页";
    }


    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "GET-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "POST-张三";
    }


    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "PUT-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-张三";
    }
}
