package com.hspedu.innerclass;

public class LocallnnerClass {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.f1();
    }
}


class AA {
    private int a = 120;
    private void work() {
        System.out.println("我是外部类的一个方法。");
    }

    public void f1() {
        class BB {
            int b = 200;
            int a = 3333;
            private void work2() {
                System.out.println("我是内部类的一个方法");
                System.out.println("外部的a = " + AA.this.a + "\n内部的a = " + a);
                System.out.println("=======下面是调用的外部方法work()=========");
                work();
            }
        }

        BB bb = new BB();
        bb.work2();
    }
}