package com.chaoren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/togo")
    public String togo(HttpServletRequest request) {
        request.setAttribute("name", "任超");
        request.setAttribute("password","123456");
        return "forward:/success";
    }

    @GetMapping("/requestMap")
    public String testRequestMap(Map<String,String> map,
                                 Model model) {
        map.put("name", "任超你好。。");
        model.addAttribute("da_name", "大融城");
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("success")
    public Map<String,Object> success(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", request.getAttribute("name"));
        map.put("da_name", request.getAttribute("da_name"));
        return map;
    }
}
