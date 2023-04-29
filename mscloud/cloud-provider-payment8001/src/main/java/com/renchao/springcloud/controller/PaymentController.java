package com.renchao.springcloud.controller;


import com.renchao.springcloud.entities.CommonResult;
import com.renchao.springcloud.entities.Payment;
import com.renchao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入操作返回结果:" + result);
        if (result > 0) {
            return new CommonResult<>(200, "插入成功,返回结果"+result+"\t 服务端口："+serverPort, result);
        } else {
            return new CommonResult<>(444, "插入数据失败！", null);
        }
    }


    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询操作返回结果:" + payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功"+"\t 服务端口："+serverPort, payment);
        } else {
            return new CommonResult<>(444, "查询失败", null);
        }
    }

    @RequestMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }


    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut() {
        System.out.println("*****paymentFeignTimeOut from port: "+serverPort);
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi ,I'm paymentZipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }
}
