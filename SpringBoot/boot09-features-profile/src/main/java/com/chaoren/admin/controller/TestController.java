package com.chaoren.admin.controller;

import com.chaoren.admin.bean.Boy;
import com.chaoren.admin.bean.Color;
import com.chaoren.admin.bean.Person;
import com.chaoren.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Value("${person.name:王道月}")
    String name;

    @Autowired
    Boy boy;

//    @Autowired
//    Person person;

    @Autowired
    HelloService helloService;

    @RequestMapping("/hello")
    public String testHello() {

        return helloService.sayHello("任超");
    }

//    @Autowired
//    Color color;

//    @RequestMapping("/")
//    public Map<String,Object> test01() {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("person", person);
//        map.put("color", color);
//
//        return map;
//    }

    @RequestMapping("/person")
    public Boy test02() {
        return boy;
    }
}
