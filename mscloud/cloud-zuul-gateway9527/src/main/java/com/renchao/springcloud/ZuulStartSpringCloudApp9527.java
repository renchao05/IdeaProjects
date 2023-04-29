package com.renchao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulStartSpringCloudApp9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulStartSpringCloudApp9527.class, args);
    }
}
