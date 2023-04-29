package com.chaoRen.aop.proxy.ProxyDemo;

/**
 * 测试类
 */
public class Test1 {
    public static void main(String[] args) {
        HelloInterface helloInterface = new HelloProxy();
        helloInterface.sayHello();
    }
}
