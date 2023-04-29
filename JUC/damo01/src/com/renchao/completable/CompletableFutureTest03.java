package com.renchao.completable;

import java.util.concurrent.CompletableFuture;

/**
 * 线程依赖
 */
public class CompletableFutureTest03 {
    private static Integer num = 10;
    /**
     * 先对一个数加 10,然后取平方
     */
    public static void main(String[] args) throws Exception{
        System.out.println("主线程开始");
        CompletableFuture<Integer> future =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.println("加 10 任务开始");
                        num += 10;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return num;
                }).thenApply(integer -> num * num);
        Integer integer = future.get();
        System.out.println("主线程结束, 子线程的结果为:" + integer);
    }
}
