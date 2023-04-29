package com.renchao.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest02 {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " 开始读了。。。");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " 读结束了。。。");
            lock.readLock().unlock();
        }
    }

    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " 获取到写锁。。。");
            Thread.sleep(3000);
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " 获取到读锁。。。");
            Thread.sleep(3000);
            lock.writeLock().unlock();
            System.out.println(Thread.currentThread().getName() + " 释放写锁。。。");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
            System.out.println(Thread.currentThread().getName() + " 释放读锁。。。");
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockTest02 test = new ReentrantReadWriteLockTest02();
        Thread t1 = new Thread(test::read, "ReadThread1");
        Thread t2 = new Thread(test::read, "ReadThread2");
        Thread t3 = new Thread(test::write, "WriteThread3");
        Thread t4 = new Thread(test::write, "WriteThread4");

//        t1.start();
//        t2.start();
        t3.start();
//        t4.start();
        // 分别测试 读读t1、t2；  读写t2、t3； 写写t3、t4。
        t1.start();
    }
}
