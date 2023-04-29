package com.renchao.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5);

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "到了。。。");
                try {
                    barrier.await();
                    System.out.println("5个人到齐了！！！==========" + Thread.currentThread().getName() + " 进来了！");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "第" + i + "个人").start();
        }
    }
}
