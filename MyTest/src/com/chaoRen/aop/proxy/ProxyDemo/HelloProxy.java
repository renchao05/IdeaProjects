package com.chaoRen.aop.proxy.ProxyDemo;

/**
 * 代理类
 */
public class HelloProxy implements HelloInterface{
    private HelloInterface helloInterface = new Hello();
    @Override
    public void sayHello() {
        System.out.println("前置，Hello!");
        helloInterface.sayHello();
        System.out.println("后置，Hello!");
    }

    @Override
    public int addition(int i1, int i2) {
        return 0;
    }
}
