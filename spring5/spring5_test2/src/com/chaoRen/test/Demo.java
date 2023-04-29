package com.chaoRen.test;

public class Demo {
    public static void main(String[] args) {
        B a = new B();
        a.methodB();
        a.methodA();
    }
}


class A {
    protected void methodA() {
        System.out.println("methodA...");
    }
}


class B extends A {
    void methodB() {
        System.out.println("methodB...");
    }
}