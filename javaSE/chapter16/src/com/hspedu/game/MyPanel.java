package com.hspedu.game;

import javax.swing.*;
import java.awt.*;

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int x = 140;
        int y = 60;
        g.setColor(Color.CYAN);
//        g.drawRect(x + 17, y + 15, 44, 54);//中间矩形框
        g.fillRect(x + 10, y + 10, 20, 40);//中间矩形
        g.fillRect(x, y, 10, 60);//左轮
        g.fillRect(x + 30, y, 10, 60);//右轮
        g.setColor(Color.PINK);
        g.fillOval(x + 10, y + 20, 20, 20);//中间圆
        g.fillRect(x + 18, y, 4, 30);//炮筒
    }
}
