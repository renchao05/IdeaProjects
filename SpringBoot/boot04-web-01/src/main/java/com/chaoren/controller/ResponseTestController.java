package com.chaoren.controller;

import com.chaoren.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseTestController {

    @ResponseBody
    @RequestMapping("/test/person")
    public Person getPerson() {
        Person person = new Person();
        person.setUserName("renchao");
        person.setAge(31);
        person.setBirth(new Date());
        return person;
    }
}
