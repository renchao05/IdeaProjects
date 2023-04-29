package com.renchao.commun;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo03 {
    public static void main(String[] args) {
        DemoClass03 demoClass = new DemoClass03();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                demoClass.printA(i);
            }
        }, "a").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                demoClass.printB(i);
            }
        }, "b").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                demoClass.printC(i);
            }
        }, "c").start();


    }
}


class DemoClass03 {
    private int i = 0;
    private final Lock lock = new ReentrantLock();

    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();
    private final Condition conditionC = lock.newCondition();

    /**
     * 打印5次A
     */
    public void printA(int j) {
        try {
            lock.lock();
            while (i != 0) {
                System.out.println("A要睡了");
                conditionA.await();
                System.out.println("A醒了");
            }
            System.out.println("====第 " + j + " 轮开始======");
            System.out.println(Thread.currentThread().getName() + "输出开始==");
            for (int k = 0; k < 5; k++) {
                System.out.println("A");
            }
            Thread.sleep(3000);
            i = 1;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印10次B
     */
    public void printB(int j) {
        try {
            lock.lock();
//            System.out.println("B醒了==");
            while (i != 1) {
                System.out.println("B要睡了");
                conditionB.await();
                System.out.println("B醒了");
            }
            System.out.println(Thread.currentThread().getName() + "输出开始==");
            for (int k = 0; k < 10; k++) {
                System.out.println("B");
            }
            Thread.sleep(3000);
            i = 2;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印15次C
     */
    public void printC(int j) {
        try {
            lock.lock();
            while (i != 2) {
                System.out.println("C要睡了");
                conditionC.await();
                System.out.println("C醒了");
            }
            System.out.println(Thread.currentThread().getName() + "输出开始==");
            for (int k = 0; k < 15; k++) {
                System.out.println("B");
            }
            Thread.sleep(3000);
            i = 0;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}