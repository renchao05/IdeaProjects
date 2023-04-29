package com.renchao.completable;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest06 {
    private static Integer num = 10;

    /**
     * 先对一个数加 10,然后取平方
     */
    public static void main(String[] args) throws Exception {
        System.out.println("主线程开始");
        //第一步加 10
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("加 10 任务开始");
            num += 10;
            return num;
        });
        //合并
        CompletableFuture<Integer> future1 = future.thenCompose(i ->
                //再来一个 CompletableFuture
                CompletableFuture.supplyAsync(() -> {
                    return i + 1;
                }));
        System.out.println(future1.get());
        System.out.println(future.get());
    }
}
