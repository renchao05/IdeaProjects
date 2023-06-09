package com.renchao.test;

public class VolatileTest {

    /**
     * main 方法作为一个主线程
     */
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        // 开启线程
        myThread.start();

        // 主线程执行
        for (; ; ) {
            if (myThread.isFlag()) {
                System.out.println("主线程访问到 flag 变量");
            }
        }
    }

    public void volatileTest() {
        System.out.println("=========");
        MyThread myThread = new MyThread();
        myThread.show();
        myThread.isFlag();
    }

}

/**
 * 子线程类
 */
class MyThread extends Thread {

    private volatile static boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 修改变量值
        flag = true;
        System.out.println("flag = " + flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void show() {
        System.out.println("=======");
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
