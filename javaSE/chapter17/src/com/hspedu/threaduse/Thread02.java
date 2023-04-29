package com.hspedu.threaduse;

public class Thread02 {
    public static void main(String[] args) throws InterruptedException {
        Dog dog = new Dog();
        Thread thread = new Thread(dog,"小狗");
        System.out.println(thread.getState());
        thread.start();
            Thread.sleep(20000);

        System.out.println(thread.getState());
    }
}

class Dog implements Runnable {

    int times = 0;
    @Override
    public void run() {
        int i = 0;
        while (i++ < 11) {
            System.out.println("小狗汪汪叫。。。Hi!" + ++times + "次。进程名：" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getState());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getState());
        }
    }
}