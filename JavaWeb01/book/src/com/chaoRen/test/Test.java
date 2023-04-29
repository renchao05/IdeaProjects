package com.chaoRen.test;

import java.lang.reflect.Method;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        int dig = dig(10);
        System.out.println(dig);

    }

    public static int dig(int i) {
        if (i==1)
            return 1;
        if (i==2)
            return 2;
        return dig(i - 1) + dig(i - 2);
    }
}

class A {
    public void a(Integer i) {
        String action = "c";
        try {
            Method method = this.getClass().getDeclaredMethod(action,Integer.class);
            method.invoke(this,i);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class B extends A {
//    @Override
//    public void a() {
//        super.a();
//    }

    public void b(Integer i) {
        System.out.println("B类b方法");
        System.out.println(i);
    }

    public void c(Integer i) {
        System.out.println("B类c方法");
        System.out.println(i);
    }
}