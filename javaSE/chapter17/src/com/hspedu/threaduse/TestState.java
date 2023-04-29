package com.hspedu.threaduse;

public class TestState {
    public static void main(String[] args) throws InterruptedException {
        new A().start();    // 先上锁
        A a = new A();  //a在锁外面的状态  BLOCKED
        B b = new B();  //b在等待睡眠时的状态 TIMED_WAITING
        C c = new C();  //c被其他线程插队后等待时的状态 WAITING
        D d = new D();
        System.out.println("====== 测试 NEW、RUNNABLE、TERMINATED 状态 ======");
        System.out.println("d刚创建的状态： " + d.getState());
        d.start();
        Thread.sleep(1000);
        System.out.println("d运行完以后的状态： " + d.getState());

        a.start();
        b.start();
        c.start();

        System.out.println("====== 测试 BLOCKED、TIMED_WAITING、WAITING 状态 ======");
        Thread.sleep(3000);
        System.out.println("a的状态： " + a.getState());
        System.out.println("b的状态： " + b.getState());
        System.out.println("c的状态： " + c.getState());
    }
}

/**
 * 测试 BLOCKED 状态
 */
class A extends Thread {
    static final Object o = new Object();
    @Override
    public void run() {
        synchronized (o) {  // 先进来一个锁住，然后测试后面线程的等待状态
            try {
                sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 测试 TIMED_WAITING 状态
 */
class B extends Thread {
    @Override
    public void run() {
        try {
            sleep(30000);   // 等待睡眠结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 测试 WAITING 状态
 */
class C extends Thread {
    @Override
    public void run() {
        int i = 0;
        B b = new B();
        b.start();
        try {
            b.join();   // 被b线程插队
            while (i++ < 10) {
                sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 测试 NEW、RUNNABLE、TERMINATED 状态
 */
class D extends Thread {
    @Override
    public void run() {
        System.out.println("d的运行状态：" + Thread.currentThread().getState());
    }
}