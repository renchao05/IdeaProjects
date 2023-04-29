package com.renchao.lock;

import java.util.concurrent.locks.ReentrantLock;

public class SellingTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(() -> {
            while (ticket.getTicket() > 0) {
                ticket.sell();
            }
        }, "售票员A ").start();

        new Thread(() -> {
            while (ticket.getTicket() > 0) {
                ticket.sell();
            }
        }, "售票员B ").start();

        new Thread(() -> {
            while (ticket.getTicket() > 0) {
                ticket.sell();
            }
        }, "售票员C ").start();


    }

}

class Ticket {

    public int getTicket() {
        return ticket;
    }

    private int ticket = 30;

    private final ReentrantLock lock = new ReentrantLock(true);

    public void sell() {
        try {
            lock.lock();
            if (ticket <= 0) {
                return;
            }
            ticket--;
            System.out.println(Thread.currentThread().getName() + "卖出一张，剩余：" + ticket);

        } finally {
            lock.unlock();
        }
    }
}