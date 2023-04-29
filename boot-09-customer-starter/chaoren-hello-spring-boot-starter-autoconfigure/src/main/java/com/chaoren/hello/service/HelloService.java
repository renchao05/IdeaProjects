package com.chaoren.hello.service;

import com.chaoren.hello.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloService {
    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String username) {
        return helloProperties.getPrefix() + ": " + username + " > " + helloProperties.getSuffix();
    }
}
