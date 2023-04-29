package com.renchao.springcloud.controller;

import com.renchao.springcloud.domain.CommonResult;
import com.renchao.springcloud.domain.Order;
import com.renchao.springcloud.service.AccountService;
import com.renchao.springcloud.service.OrderService;
import com.renchao.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/createOrder")
    public CommonResult<String> createOrder(Order order) {
        orderService.create(order);
        return new CommonResult<>(200, "OK", "创建成功！");
    }
}
