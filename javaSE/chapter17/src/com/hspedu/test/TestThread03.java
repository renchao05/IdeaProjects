package com.hspedu.test;

public class TestThread03 {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        CC cc1 = new CC(o1, o2, false);
        CC cc2 = new CC(o1, o2, true);
        cc1.start();
        cc2.start();

    }
}


class CC extends Thread {
    Object o1, o2;
    boolean b;

    public CC(Object o1, Object o2, boolean b) {
        this.o1 = o1;
        this.o2 = o2;
        this.b = b;
    }

    @Override
    public void run() {

        if (b) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + " 进入1区");

                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + " 进入2区");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " 进入3区");

                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " 进入4区");
                }
            }
        }
    }
}