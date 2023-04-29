package com.chaoren.admin.config;

import com.chaoren.admin.bean.Color;
import com.chaoren.hello.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MyConfig {

    @Profile("prod")
    @Bean
    public Color red() {
        return new Color("生产环境，红色");
    }

    @Profile("test")
    @Bean
    public Color green() {
        return new Color("测试环境，绿色");
    }

//    @Bean
    public HelloService helloService() {
        HelloService helloService = new HelloService();
        return helloService;
    }
}
