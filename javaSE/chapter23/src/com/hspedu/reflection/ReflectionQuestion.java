package com.hspedu.reflection;

import com.hspedu.Cat;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionQuestion {
    public static void main(String[] args) throws Exception {
//        Class<?> aClass = Class.forName("com.hspedu.Cat");
//        Method cry = aClass.getMethod("hi");
//        Object o = aClass.newInstance();
//        cry.invoke(o);
//        Field age = aClass.getField("age");
//        System.out.println(age.get(o));
        m1();
        m2();
//        m3();
    }

    public static void m1() {
        Long sum = 0L;
        Cat cat = new Cat();
        long l = System.currentTimeMillis();
        for (Long i = 0L; i < 90000000; i++) {
            sum += cat.hi(i, sum);
        }
        long l1 = System.currentTimeMillis();
        System.out.println("M1的用时：" + (l1 - l));
    }

    public static void m2() throws Exception {
        Long sum = 0L;
        Class<?> aClass = Class.forName("com.hspedu.Cat");
        Object o = aClass.newInstance();
        Method hi = aClass.getMethod("hi",Long.class,Long.class);
        long l = System.currentTimeMillis();
        for (Long i = 0L; i < 90000000; i++) {
            sum += (Long) hi.invoke(o,sum,i);
        }
        long l1 = System.currentTimeMillis();
        System.out.println("M2的用时：" + (l1 - l));
    }

    public static void m3() throws Exception {
        Class<?> aClass = Class.forName("com.hspedu.Cat");
        Object o = aClass.newInstance();
        Method hi = aClass.getMethod("hi");
        long l = System.currentTimeMillis();
        hi.setAccessible(true);
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(o);
        }
        long l1 = System.currentTimeMillis();
        System.out.println("M3的用时：" + (l1 - l));
    }
}


