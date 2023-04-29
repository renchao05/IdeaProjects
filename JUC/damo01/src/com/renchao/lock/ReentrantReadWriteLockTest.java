package com.renchao.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁测试
 */
public class ReentrantReadWriteLockTest {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " 开始读了。。。");
            Thread.sleep(3000);
//            write();    // 会发生死锁，当前线程持有读锁的同时，试图再次获取写锁（读锁必须要先释放）
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
            System.out.println(Thread.currentThread().getName() + " 开始写了。。。");
            Thread.sleep(3000);
            read();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " 写完了。。。");
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockTest test = new ReentrantReadWriteLockTest();
        Thread t1 = new Thread(test::read, "ReadThread1");
        Thread t2 = new Thread(test::read, "ReadThread2");
        Thread t3 = new Thread(test::write, "WriteThread3");
        Thread t4 = new Thread(test::write, "WriteThread4");

//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        t1.start();
        // 分别测试 读读t1、t2；  读写t2、t3； 写写t3、t4。
    }
}
