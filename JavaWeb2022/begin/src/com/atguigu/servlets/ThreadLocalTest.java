package com.atguigu.servlets;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalTest {

    //    static ThreadLocal<String> localVar = new ThreadLocal<>();
    static MyThread localVar = new MyThread();

    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get());
        //清除本地内存中的本地变量
        localVar.remove();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                localVar.set("localVar1");
                //调用打印方法
                print("thread1");
                //打印本地变量
                System.out.println("after remove : " + localVar.get());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                localVar.set("localVar2");
                //调用打印方法
                print("thread2");
                //打印本地变量
                System.out.println("after remove : " + localVar.get());
            }
        });

        t1.start();
        t2.start();
    }
}

class MyThread {
    private final Map<Thread, Map<MyThread, String>> threadMap = new HashMap<>();

    public String get() {
        Thread t = Thread.currentThread();
        Map<MyThread, String> map = getMap(t);
        return map == null ? null : map.get(this);
    }

    public void set(String str) {
        Thread t = Thread.currentThread();
        Map<MyThread, String> map = getMap(t);
        if (map != null) {
            map.put(this, str);
        } else {
            createMap(t, str);
        }
    }

    public void remove() {
        Thread t = Thread.currentThread();
        threadMap.remove(t);
    }

    public Map<MyThread, String> getMap(Thread t) {
        return threadMap.get(t);
    }

    public void createMap(Thread t, String str) {
        HashMap<MyThread, String> map = new HashMap<>();
        map.put(this, str);
        this.threadMap.put(t, map);
    }
}