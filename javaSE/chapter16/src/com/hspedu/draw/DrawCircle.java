package com.hspedu.draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame {    // Frame (图画、门、玻璃等的)框架

    //定义一个面板
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() {
        //初始化面板
        mp =new MyPanel();
        this.add(mp);   //把面板放入到窗口（画框）
        this.setSize(450,320);  //设置窗口大小
        this.setVisible(true);  //让窗口可见
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyPanel extends JPanel {  //Panel 面板
    //MyPanel 对象就是一个画板
    //Graphics g 就相当于一个画笔
    @Override
    public void paint(Graphics g) {  //paint 在…上刷油漆;用颜料画;把…描绘成
        super.paint(g);
        g.drawOval(5,5,50,50); //画一个圆

        g.drawLine(65,5,90,55); //画一个直线
        g.drawRect(100,5,50,50);    //画一个矩形
        g.setColor(Color.BLUE); //设置画笔颜色
        g.fillRect(165,5,50,50);    //填充一个矩形
        g.setColor(Color.red); //设置画笔颜色
        g.fillOval(230,5,50,50);    //填充一个圆形
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/222.jpg")); //获取图片资源
        g.drawImage(image,295,5,50,50,this); //画图片
        g.setColor(Color.magenta);//设置画笔颜色
        g.setFont(new Font("仿宋",Font.BOLD,50));//设置字体
        g.drawString("任超",165,120);//写字
    }
}














