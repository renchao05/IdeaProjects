package com.renchao.springcloud.controller;

import com.renchao.springcloud.entities.CommonResult;
import com.renchao.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        return new CommonResult<>(200, serverPort, new Payment(id, "测试"));
    }
}
