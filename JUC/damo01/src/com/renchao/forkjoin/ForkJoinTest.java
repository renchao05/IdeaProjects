package com.renchao.forkjoin;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask task = new MyTask(0L, 100000L);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        System.out.println(submit.get());
        forkJoinPool.shutdown();
    }
}

class MyTask extends RecursiveTask<Long> {

    public static final int THRESHOLD = 10;

    private final long start;
    private final long end;

    public MyTask(long start,long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long result = 0L;
        if (end - start < THRESHOLD) {
            for (long i = start; i <= end; i++) {
                result += i;
            }
        } else {
            long median = (end + start) / 2;
            MyTask task1 = new MyTask(start, median);
            MyTask task2 = new MyTask(median + 1, end);
            task1.fork();
            task2.fork();
            result = task1.join() + task2.join();
        }

        return result;
    }
}