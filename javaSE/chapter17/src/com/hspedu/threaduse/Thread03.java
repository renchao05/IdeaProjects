package com.hspedu.threaduse;

public class Thread03 {
    public static void main(String[] args) {
        new Hello().start();
        new Thread(new Hi()).start();
        System.out.println("主线程结束！！！");
    }
}

class Hello extends Thread {
    int i = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello,world! " + ++i + "次。");
            if (i == 50)
                break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Hi implements Runnable {
    int i =0;
    @Override
    public void run() {
        while (true) {
            System.out.println("Hi! " + ++i + "次。");
            if (i == 100)
                break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}