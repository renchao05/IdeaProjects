package com.hspedu.tankgame;


import javax.swing.*;
import java.awt.*;


/**
 * 坦克大战的绘图区域
 */
public class MyPanel extends JPanel {
    //定义我方坦克
    public Hero hero = null;

    public MyPanel() {
        hero = new Hero(100,100);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);

        //画出坦克，封装的方法
        drawTank(hero.getX(), hero.getY(),g,0,0);
    }


    /**
     *
     * @param x 坦克横坐标
     * @param y 坦克纵坐标
     * @param g 画笔
     * @param direct 坦克方向（上下左右）
     * @param type 坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        switch (type) {
            case 0: //我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //敌人坦克
                g.setColor(Color.yellow);
                break;
        }
        switch (direct) {
            case 0: //向上
                g.fill3DRect(x + 10, y + 10, 20, 40,false);//中间矩形
                g.fill3DRect(x, y, 10, 60,false);//左轮
                g.fill3DRect(x + 30, y, 10, 60,false);//右轮
                g.fillOval(x + 9, y + 20, 20, 20);//中间圆盖
                g.fill3DRect(x + 18, y, 4, 30,false);//炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }
}
