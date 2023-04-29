package com.renchao.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BuyTickets {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(3,
                3,
                0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());

        try {
            for (int i = 1; i <= 10; i++) {
                int finalI = i;
                executor.submit(() -> {
                    System.out.println("第 " + finalI + " 个乘客正在：" + Thread.currentThread().getName() + " 处购票。。。");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } finally {
            executor.shutdown();
        }
    }
}
