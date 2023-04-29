package com.renchao.commun;

public class TestVolatile {

    /**
     * 交替加减
     */
    public static void main(String[] args) {
        DemoClass01 demoClass01 = new DemoClass01();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                demoClass01.increment();
            }
        }, "线程 A").start();


        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                demoClass01.decrement();
            }
        }, "线程 B").start();
    }
}

class DemoClass01 {
    //加减对象
    private int number = 0;

    /**
     * 加 1
     */
    public synchronized void increment() {
        try {
            while (number != 0) {
                this.wait();
            }
            number++;
            System.out.println("--------" + Thread.currentThread().getName() + "加一成功----------,值为:" + number);
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 减 1
     */
    public synchronized void decrement() {
        try {
            while (number == 0) {
                this.wait();
            }
            number--;
            System.out.println("--------" + Thread.currentThread().getName() + "减一成功----------,值为:" + number);
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}