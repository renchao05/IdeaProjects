package com.chaoren.demo01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController3 {

    @RequestMapping("test-api")
    public String testApi(HttpServletRequest request) {

        String authorization = request.getHeader("Authorization");
        System.out.println(authorization);
        return "forward:/test/success";
    }
}
