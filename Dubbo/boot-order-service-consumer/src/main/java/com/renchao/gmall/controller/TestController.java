package com.renchao.gmall.controller;


import com.renchao.gmall.bean.UserAddress;
import com.renchao.gmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/getOrder")
    public List<UserAddress> getOrder(@RequestParam("uid") String id) {
        return orderService.initOrder(id);
    }
}
