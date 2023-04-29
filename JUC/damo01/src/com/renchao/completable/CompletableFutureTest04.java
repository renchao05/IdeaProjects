package com.renchao.completable;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class CompletableFutureTest04 {
    private static Integer num = 10;

    /**
     * 先对一个数加 10,然后取平方
     */
    public static void main(String[] args) throws Exception {
        System.out.println("主线程开始");
        CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.println("加 10 任务开始");
                        num += 10;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return num;
                })
                .thenApply(integer -> num * num)
                .thenAccept(integer -> System.out.println("子线程全部处理完成,最后调用了 accept,结果为:" + integer));
    }
}
