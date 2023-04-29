package com.chaoren.demo01.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController2 {

    @RequestMapping("/add.html")
    public String add() {
        return "add";
    }


    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping("/success.html")
    public String success() {
        return "success";
    }



}
