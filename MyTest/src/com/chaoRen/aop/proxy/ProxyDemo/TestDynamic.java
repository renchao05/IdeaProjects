package com.chaoRen.aop.proxy.ProxyDemo;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 测试类
 */
public class TestDynamic {
    public static void main(String[] args) {
        Hello hello = new Hello();
        InvocationHandler handler = new HelloProxyDynamic(hello);
        HelloInterface helloInterface = (HelloInterface)
                Proxy.newProxyInstance(
                handler.getClass().getClassLoader(),
                hello.getClass().getInterfaces(),
                handler);
        helloInterface.sayHello();
    }


    @Test
    public void test2() {
        Hello hello = new Hello();
        HelloInterface helloInterface = (HelloInterface)
                Proxy.newProxyInstance(TestDynamic.class.getClassLoader(),
                        hello.getClass().getInterfaces(),
                        new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("前置【" + method.getName() + "】传递的参数：" + Arrays.toString(args));
                Object invoke = method.invoke(hello, args);
                System.out.println(invoke);
                System.out.println("后置。。。。。");
                return invoke;
            }
        });
        helloInterface.addition(5,9);
    }
}
