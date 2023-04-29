package com.hspedu.test;

public class TestThread {

    public static void main(String[] args) {
        T2 t2 = new T2();
        T2 t21 = new T2();
        new T(t21,"1111").start();
        new T(t21,"2222").start();
        new T(t2,"3333").start();
        new T(t2,"4444").start();
    }
}

class T extends Thread {
    T2 t2;
    String userId;

    public T(T2 t2,String userId){
        this.t2 = t2;
        this.userId = userId;
    }
    public void run() {
        t2.m(userId);
    }
}

class T2{
    public void m(String userId) {
        System.out.println("m................");
        synchronized (this) {
            try {
                System.out.println("userId:" + userId);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}