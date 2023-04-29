package com.renchao.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    private final Lock lock = new ReentrantLock(); //注意每次调用必须是同一把锁

    public void insert() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到了锁");
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "运行：" + i);
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        new Thread(test::insert, "AA").start();
        new Thread(test::insert, "BB").start();
    }

}
