package com.chaoRen.spring5.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10000)
public class UserProxy {

    @Pointcut(value = "execution(* com.chaoRen.spring5.aopanno.User.add(..))")
    public void pointDemo() {}

    //前置通知
    @Before(value = "pointDemo()")
    public void before() {
        System.out.println("before.....");
    }

    //最终通知
    @After(value = "pointDemo()")
    public void after() {
        System.out.println("After.....");
    }

    //返回通知（发生错误不执行）
    @AfterReturning(value = "pointDemo()")
    public void afterReturning() {
        System.out.println("AfterReturning.....");
    }

    //错误抛出通知（发生错误执行）
    @AfterThrowing(value = "pointDemo()")
    public void afterThrowing() {
        System.out.println("AfterThrowing.....");
    }

    //环绕通知（发生错误环绕之后不执行）
    @Around(value = "pointDemo()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("环绕之前.....");
        point.proceed();
        System.out.println("环绕之后.....");
    }
}
