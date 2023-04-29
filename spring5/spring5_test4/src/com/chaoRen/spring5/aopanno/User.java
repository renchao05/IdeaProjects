package com.chaoRen.spring5.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
public class User {
    public void add() {
        System.out.println("User,add...");
//        int i = 6/0;
    }
}
