package com.chaoren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafTestController {

    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Model model) {
        model.addAttribute("test", "你好，任超。。");
        model.addAttribute("link", "https://www.baidu.com/");
        model.addAttribute("bname", "上百度");
        return "success";
    }
}
