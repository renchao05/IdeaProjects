package com.hspedu.tankgame2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Vector;


/**
 * 坦克大战的绘图区域
 */
public class MyPanel extends JPanel implements KeyListener {
    //定义我方坦克
    Hero hero = null;
    List<EnemyTank> enemyTank = new Vector<>();
    int enemyTankSize = 5;

    public MyPanel() {
        hero = new Hero(100, 100);
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemy = new EnemyTank(100 * (i + 1), 10);
            enemy.setDirect(2);
            enemyTank.add(enemy);
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        //画出坦克，封装的方法
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        for (EnemyTank o : enemyTank) {
            drawTank(o.getX(), o.getY(), g, o.getDirect(), 0);
        }

    }


    /**
     * @param x      坦克横坐标
     * @param y      坦克纵坐标
     * @param g      画笔
     * @param direct 坦克方向（上下左右）
     * @param type   坦克类型
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
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//中间矩形
                g.fill3DRect(x, y, 10, 60, false);//左轮
                g.fill3DRect(x + 30, y, 10, 60, false);//右轮
                g.fillOval(x + 9, y + 20, 20, 20);//中间圆盖
                g.fill3DRect(x + 18, y, 4, 30, false);//炮筒
                break;
            case 1: //向右
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//中间矩形
                g.fill3DRect(x, y, 60, 10, false);//左轮
                g.fill3DRect(x, y + 30, 60, 10, false);//右轮
                g.fillOval(x + 20, y + 9, 20, 20);//中间圆盖
                g.fill3DRect(x + 30, y + 18, 30, 4, false);//炮筒
                break;
            case 2: //向下
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//中间矩形
                g.fill3DRect(x, y, 10, 60, false);//左轮
                g.fill3DRect(x + 30, y, 10, 60, false);//右轮
                g.fillOval(x + 9, y + 20, 20, 20);//中间圆盖
                g.fill3DRect(x + 18, y + 30, 4, 30, false);//炮筒
                break;
            case 3: //向左
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//中间矩形
                g.fill3DRect(x, y, 60, 10, false);//左轮
                g.fill3DRect(x, y + 30, 60, 10, false);//右轮
                g.fillOval(x + 20, y + 9, 20, 20);//中间圆盖
                g.fill3DRect(x, y + 18, 30, 4, false);//炮筒
                break;

            default:
                System.out.println("暂时没有处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.moveRight();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
