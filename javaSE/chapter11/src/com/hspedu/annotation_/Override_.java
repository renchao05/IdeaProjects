package com.hspedu.annotation_;


public class Override_ {
    public static void main(String[] args) {
        B b = new B();
        b.say();
        A a = new A();
        a.say();
    }

}


class B extends A {

    @Override
    void say() {
        super.say();
    }
}

@SuppressWarnings("all")
class A {
    @Deprecated
    void say() {

        System.out.println("我是say");
    }
}