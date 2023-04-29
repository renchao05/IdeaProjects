package com.renchao.java;

public class OperandStackTest {
    public OperandStackTest() {
        super();
    }

    public OperandStackTest(String name) {
        this();
    }

    int i = 10;

    public static void main(String[] args) {
        OperandStackTest stackTest = new OperandStackTest();

        stackTest.test01(new C());
    }

    public void test01(A a) {
        a.eat();
    }

    public int getNum(B b) {
        b.action();
        return 0;
    }

    public void test02(C c) {
        c.action();
        c.eat();
        c.sc();
    }
}


class A {
    public void eat() {
        System.out.println("吃东西");
    }
}

interface B {
    public void action();
}

class C extends A implements B {

    public static void sc() {
        System.out.println("我是静态方法。。。");
    }
    @Override
    public final void eat() {
        System.out.println("C吃东西。。");
    }

    @Override
    public void action() {
        System.out.println("C行动。。。");
        eat();
        test();
        test2();
    }

    private void test() {

    }

    public final void test2() {

    }
}