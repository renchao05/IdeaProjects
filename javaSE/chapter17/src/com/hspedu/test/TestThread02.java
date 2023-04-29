package com.hspedu.test;

public class TestThread02 {
    public static void main(String[] args) {
        Object o = new Object();
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread(o);
            thread.start();
        }
    }
}


class Sync {

    public void test(Object o) {
        synchronized(Sync.class) {
            System.out.println("test开始..");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test结束..");
        }
    }
}

class MyThread extends Thread {
    Object o;

    public MyThread(Object o) {
        this.o = o;
    }

    public void run() {
        Sync sync = new Sync();
        sync.test(o);
    }
}