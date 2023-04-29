package com.chaoRen.aop.proxy.ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 */
public class HelloProxyDynamic implements InvocationHandler {
    private Object subject;

    public HelloProxyDynamic(Object subject) {
        this.subject = subject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置" + method.getName());
        method.invoke(subject, args);
        System.out.println("后置" + method.getName());
        return null;
    }
}
