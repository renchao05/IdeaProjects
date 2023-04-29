package com.hspedu.homework;

import com.hspedu.PrivateTest;

import java.lang.reflect.Field;

public class homework01 {
    public static void main(String[] args) throws Exception {
        Class<?> pt = Class.forName("com.hspedu.PrivateTest");
        Object o = pt.newInstance();
        System.out.println(o.getClass());
        Field name = pt.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"你好，我已经被修改了。。。。");

        System.out.println(pt.getMethod("getName").invoke(o));

        System.out.println(((PrivateTest)o).getName());
    }
}