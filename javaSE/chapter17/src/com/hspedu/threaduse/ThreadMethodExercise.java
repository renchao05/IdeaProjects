package com.hspedu.threaduse;

public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        Hello2 hello2 = new Hello2();
        Thread thread = new Thread(hello2);
//        thread.setDaemon(true);
        for (int i = 1; i <= 10; i++) {
            System.out.println("hi " + i);
            if (i == 5) {
                thread.start();
                thread.join();
            }
            Thread.sleep(1000);
        }

        thread.start();
        Thread.sleep(5000);
        System.out.println("主线程序结束。。。");
    }
}


class Hello2 implements Runnable {
    int i = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("hello " + ++i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i >= 10) {
                System.out.println("子线程序结束。。。");
                break;
            }
        }
    }
}