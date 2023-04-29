package com.renchao.commun;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo02 {
    public static void main(String[] args) {
        DemoClass demoClass = new DemoClass();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                demoClass.increment();
            }
        }, "加法线程AA").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                demoClass.decrement();
            }
        }, "减法线程BB").start();
    }
}

class DemoClass{
    //加减对象
    private int number = 0;
    //声明锁
    private final Lock lock = new ReentrantLock();
    //声明钥匙
    private final Condition condition = lock.newCondition();
    /**
     * 加 1
     */
    public void increment() {
        try {
            lock.lock();
            while (number != 0){
                condition.await();
            }
            number++;
            System.out.println("--------" + Thread.currentThread().getName() + "加一成功----------,值为:" + number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    /**
     * 减一
     */
    public void decrement(){
        try {
            lock.lock();
            while (number == 0){
                condition.await();
            }
            number--;
            System.out.println("--------" + Thread.currentThread().getName() + "减一成功----------,值为:" + number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
