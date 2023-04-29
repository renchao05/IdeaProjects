package com.chaoRen;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
    public static void main(String[] args) {

//        Class[] interfaces = {UserDao.class};

        UserDao userDao = new UserDaoImpl();

        UserDao u =(UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), UserDaoImpl.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法之前执行。。" + method.getName() + " :传递的参数：" + Arrays.toString(args));

                Object invoke = method.invoke(userDao, args);

                System.out.println("方法执行之后。。" + userDao);
                System.out.println("invoke的值：：：："  + invoke);
                return invoke;
            }
        });

        int add = u.add(5, 6);
        System.out.println("u的运行类型" + u.getClass());
        System.out.println("userDao的运行类型" + userDao.getClass());
        System.out.println(add);
    }
}
