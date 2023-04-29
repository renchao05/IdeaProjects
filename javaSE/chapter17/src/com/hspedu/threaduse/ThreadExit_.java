package com.hspedu.threaduse;

public class ThreadExit_ {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        new Thread(t).start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主程序在运行。。。");
            Thread.sleep(1000);
        }
        System.out.println("我要让T退出了。");
        t.stop();
    }
}

class T implements Runnable {

    private boolean b = true;

    // 通过变量b控制退出
    public void stop() {
        b = false;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("T在运行中。。。");
            if (!b) {
                System.out.println("T退出了。");
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}