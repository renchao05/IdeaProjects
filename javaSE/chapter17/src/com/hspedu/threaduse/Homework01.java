package com.hspedu.threaduse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Homework01 extends JFrame {
    public static void main(String[] args) {
        Numb numb = new Numb();
        numb.start();
        new Monitor().start();

    }
}


class Numb extends Thread {
    double numb;
    public static boolean mon = true;

    @Override
    public void run() {
        while (true) {
            numb = Math.random() * 100;
            System.out.println((int) numb);
            if (!mon) {
                System.out.println("本线程退出。。。");
                break;
            }
        }
    }
}

class Monitor extends Thread {
    @Override
    public void run() {
        new MyFrame();
    }
}

class JP extends JPanel implements KeyListener{

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Q)
            Numb.mon = false;

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

class MyFrame extends JFrame  {

    private JP jp = null;
    public MyFrame() {
        this.jp = new JP();
        this.add(jp);
        this.setSize(500,400);
        this.addKeyListener(jp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

