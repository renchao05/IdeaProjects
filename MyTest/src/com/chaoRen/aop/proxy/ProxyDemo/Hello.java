package com.chaoRen.aop.proxy.ProxyDemo;

/**
 * 被代理的实现类
 */
public class Hello implements HelloInterface{
    @Override
    public void sayHello() {
        System.out.println("Hello,我是实现类");
    }

    @Override
    public int addition(int i1, int i2) {
        return i1 + i2;
    }
}
