package com.chaoRen.spring5.aopanno;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
//@Order(Integer.MAX_VALUE)
public class PersonProxy {

    @Before(value = "execution(* com.chaoRen.spring5.aopanno.User.add(..))")
    public void Before() {
        System.out.println("Person...Before....");
    }
}
