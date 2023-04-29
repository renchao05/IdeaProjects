package com.hspedu.threaduse;

public class SellTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();

//        new Ticket2().start();
//        new Ticket2().start();
//        new Ticket2().start();
    }
}

class Ticket implements Runnable {
    int t = 30;
    boolean b =true;

    public boolean sell() {
        synchronized (this) {
            if (t <= 0) {
                System.out.println("售票结束。。。。。");
                return false;
            }
            System.out.println(Thread.currentThread().getName() + " 卖掉一张，还剩" + --t + "张！");
            return true;
        }
    }

    @Override
    public void run() {
        while (b) {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            b = sell();
        }
    }
}

class Ticket2 extends Thread {
    static int t = 100;
    @Override
    public void run() {
        while (true) {
            System.out.println("卖掉一张，还剩" + --t + "张！");
            if (t <= 0) {
                System.out.println("售票结束。。。。。");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}