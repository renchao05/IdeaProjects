package com.hspedu.threaduse;

public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        cat.start();
//        cat.run();
        for (int i = 0; i < 60; i++) {
            System.out.println("我是主线程" + i + "号。线程名：" + Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}


class Cat extends Thread {
    int times = 1;
    @Override
    public void run() {

        while (true) {
            System.out.println("我是小猫咪" + times++ + "号。线程名：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 80)
                break;
        }
    }
}