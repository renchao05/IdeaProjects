package com.renchao.springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

//@Service
public class OrderService {
    @SentinelResource("something")       // 将此方法标注为sentinel的资源。value=资源名
    public void something() {
        System.out.println("do something");
    }
}
