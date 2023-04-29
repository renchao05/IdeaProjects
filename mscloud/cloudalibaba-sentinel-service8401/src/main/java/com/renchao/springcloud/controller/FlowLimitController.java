package com.renchao.springcloud.controller;

import com.renchao.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {


    @GetMapping("/testA")
    public String testA() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(1);
        log.info("===========================");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE() {

        int a = 4/0;
        log.info("testE 测试异常比例");
        return "------testD";
    }

    @GetMapping("/testF")
    public String testF() {

        int a = 4/0;
        log.info("testE 测试异常数");
        return "------testD";
    }
}
