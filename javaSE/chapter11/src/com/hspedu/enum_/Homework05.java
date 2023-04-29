package com.hspedu.enum_;

public class Homework05 {
    public static void main(String[] args) {
        A a = new A();
        a.work();
    }
}

class A {
    private String name = "我是外部类私有变量。";
    public void work() {
        class B {
            private final String NAME = "我是内部类的私有常量。";
            public void show() {
                System.out.println(NAME);
                System.out.println(A.this.name);
            }
        }
        new B().show();
    }
}