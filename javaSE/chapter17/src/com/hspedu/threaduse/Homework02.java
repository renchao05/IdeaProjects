package com.hspedu.threaduse;

public class Homework02 {
    public static void main(String[] args) {
        WithdrawMoney wm = new WithdrawMoney();
//        new Thread(wm).start();
//        new Thread(wm).start();
        Object o = new Object();
        new WithdrawMoney2(o).start();
        new WithdrawMoney2(o).start();
    }
}

class WithdrawMoney implements Runnable {
    private int money = 10000;
    private boolean b = true;
    @Override
    public void run() {
        while (b) {
            Withdraw();

        }
    }

    public synchronized void Withdraw() {
        if (money <= 0 || money < 1000) {
            System.out.println("余额不足。。。。");
            this.b = false;
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +
                "取出1000元，余额还有：" + (money -= 1000) + "元。");
    }
}


class WithdrawMoney2 extends Thread {
    private Object o;
    private static int money = 10000;
    private boolean b = true;
    public WithdrawMoney2(Object o) {
        this.o = o;
    }
    @Override
    public void run() {
        while (b) {
            Withdraw();

        }
    }

    public void Withdraw() {
        synchronized(this) {
            if (money < 1000) {
                System.out.println("余额不足。。。。");
                this.b = false;
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    "取出1000元，余额还有：" + (money -= 1000) + "元。");
        }
    }
}