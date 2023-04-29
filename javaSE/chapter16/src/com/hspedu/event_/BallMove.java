package com.hspedu.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame {

    private MyPanel mp = null;

    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove() {
        mp =new MyPanel();
        this.add(mp);   //把面板放入到窗口（画框）
        this.setSize(450,320);  //设置窗口大小
        this.addKeyListener(mp);    //窗口JFrame监听面板发生的键盘事件。
        this.setVisible(true);  //让窗口可见
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}



class MyPanel extends JPanel implements KeyListener {  //Panel 面板

    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {  //paint 在…上刷油漆;用颜料画;把…描绘成
        super.paint(g);
        g.fillOval(x,y,50,50); //画一个圆
    }

    //监听字符输入
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //监听被按下的按键
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println((char)e.getKeyCode() + "被按下。。");
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            y++;
        else if (e.getKeyCode() == KeyEvent.VK_UP)
            y--;
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
            x--;
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            x++;
        this.repaint();

    }

    //监听按键被释放
    @Override
    public void keyReleased(KeyEvent e) {

    }
}