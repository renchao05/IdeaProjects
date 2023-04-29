package com.renchao.lock;

public class DeadlockTest {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        new Thread(() -> {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "拿到o1锁，准备获取o2锁。。。");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "拿到o2锁!");
                }
            }
        }, "AA").start();

        new Thread(() -> {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "拿到o2锁，准备获取o1锁。。。");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "拿到o1锁!");
                }
            }
        }, "BB").start();

    }
}
