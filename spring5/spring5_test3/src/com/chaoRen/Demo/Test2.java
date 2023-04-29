package com.chaoRen.Demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test2 {
    public static void main(String[] args) {
        Hello hello = new Hello();
        InvocationHandler handler = new HelloProxy(hello);
        HelloInterface helloInterface =(HelloInterface) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                hello.getClass().getInterfaces(), handler);
        helloInterface.show();
    }
}

interface HelloInterface {
    void show();
}

class Hello implements HelloInterface {

    @Override
    public void show() {
        System.out.println("我是被代理的实现类。");
    }
}

/**
 * 静态代理
 */
class HelloProxy2 implements HelloInterface {
    private HelloInterface helloInterface = new Hello();
    @Override
    public void show() {
        System.out.println("代理前置。。。。");
        helloInterface.show();
        System.out.println("代理后置。。。。");
    }
}

class HelloProxy implements InvocationHandler {

    private Object subject;

    public HelloProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置 " + method.getName());
        method.invoke(subject, args);
        System.out.println("后置 " + method.getName());
        return null;
    }
}