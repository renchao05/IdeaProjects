package com.hspedu.tankgame4;

import java.awt.*;

/**
 * 坦克爆炸线程
 */

public class Bomb extends Thread{
    public int x;
    public int y;
    public int w;
    public int h;
    public Image image =Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
    public boolean state = true;   //爆炸状态

    public Bomb(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        image =Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        image =Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        state = false;
    }
}
