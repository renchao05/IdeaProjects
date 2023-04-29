package com.chaoRen.boot.controller;

import com.chaoRen.boot.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Car car;

    @RequestMapping("/car")
    public Car car() {
        return car;
    }

    @RequestMapping("/hello")
    public String hello01() {
        return "hello SpringBoot2!!" + "\n任超你好";
    }

    @RequestMapping("/test2")
    public String hello02() {
        return "我是test2!============";
    }
}
