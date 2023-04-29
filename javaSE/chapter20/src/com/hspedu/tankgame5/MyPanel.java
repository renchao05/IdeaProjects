package com.hspedu.tankgame5;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Vector;


/**
 * 坦克大战的绘图区域
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我方坦克
    public static Tank hero = null;
    public static List<EnemyTank> enemyTank = new Vector<>(); //敌人坦克 集合
    List<Bomb> bombs = new Vector<>();  //炸弹集合
    int enemyTankSize = 5;


    /**
     * 窗口，画框
     */
    public MyPanel(int key) {
        //初始化Hero 坦克
        hero = new Hero(800, 300);
        Result.initResult();

        switch (key) {
            case 0:
                //初始化敌人坦克
                for (int i = 0; i < enemyTankSize; i++) {
                    EnemyTank enemy = new EnemyTank(100 * (i + 1), 200);
                    enemy.setDirect(2);
                    new Thread(enemy).start();

                    //给坦克加入一颗子弹
                    Shot shot = new Shot(enemy.getX() + 18, enemy.getY() + 62, enemy.getDirect());
                    enemy.shots.add(shot);  //子弹加入集合
                    shot.start();   // 子弹启动
                    enemyTank.add(enemy);   //坦克加入集合
                }
                break;
            case 1:
                Result.read();
                for (Node node : Result.node.enemy) {
                    EnemyTank enemy = new EnemyTank(node.x, node.y);
                    enemy.setDirect(node.direct);
                    new Thread(enemy).start();
                    enemyTank.add(enemy);
                }
                break;
        }


    }

    /**
     * 画笔操作
     *
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        //画出自己坦克，封装的方法
        if (hero != null)
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);

        //画出自己坦克子弹
        if (hero != null) {
            for (Shot shot : hero.shots) {
                if (shot != null && shot.isState()) {
                    drawShot(shot.getX(), shot.getY(), g);
                    //↓↓↓↓↓↓↓↓判断是否打中敌人坦克
                    for (EnemyTank tank : enemyTank) {
                        if (Hit(shot, tank)) {
                            //爆炸的坦克坐标写入集合
                            Bomb bomb = new Bomb(tank.getX(), tank.getY(),
                                    tank.endX() - tank.getX(), tank.endY() - tank.getY());
                            bombs.add(bomb);
                            Result.increaseAchievement();
                            bomb.start();   //启动爆炸线程
                        }
                    }
                }
            }
            hero.shots.removeIf(shot -> !shot.state);   //清理集合中消失的子弹
            enemyTank.removeIf(enemy -> !enemy.state);  //删除打中的坦克
        }

        //绘制坦克爆炸
        for (Bomb bomb : bombs) {
            if (bomb.state)
                g.drawImage(bomb.image, bomb.x, bomb.y, bomb.w, bomb.h, this);
        }
        bombs.removeIf(bomb -> !bomb.state);   //清理爆炸集合

        //画出敌人坦克
        for (EnemyTank enemy : enemyTank) {
            drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirect(), 0);

            //画出敌人所有子弹
            for (Shot shot : enemy.shots) {
                if (shot != null && shot.isState()) {
                    drawShot(shot.getX(), shot.getY(), g);
                    if (hero != null && Hit(shot, hero)) {
                        //爆炸的坦克坐标写入集合
                        Bomb bomb = new Bomb(hero.getX(), hero.getY(),
                                hero.endX() - hero.getX(), hero.endY() - hero.getY());
                        bombs.add(bomb);
                        bomb.start();   //启动爆炸线程
                        hero = null;
                    }
                }
            }
            enemy.shots.removeIf(shot -> !shot.state);  //清理集合中消失的子弹
        }

        //绘制菜单
        drawMenu(1000,20,g);
    }

    /**
     * 判断坦克有没有被对方击中
     *
     * @param shot 子弹
     * @param tank 坦克
     * @return 打中返回true, 没有打中返回false
     */
    public boolean Hit(Shot shot, Tank tank) {
        if (shot.getX() > tank.getX() &&
                shot.getX() < tank.endX() &&
                shot.getY() > tank.getY() &&
                shot.getY() < tank.endY()) {
            tank.state = false;
            shot.state = false;
            System.out.println("我打中了一个坦克。。。。。。。。。。。。。。。。。。。。。。。。");
            return true;
        }
        return false;
    }


    /**
     * @param x 子弹横坐标
     * @param y 子弹纵坐标
     * @param g 画笔
     */
    public void drawShot(int x, int y, Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(x, y, 4, 4);
    }

    /**
     * 绘制坦克
     *
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

    /**
     * 绘制菜单
     */
    public void drawMenu(int x, int y, Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("宋体", Font.BOLD, 25));

        g.drawString("您总共击毁坦克数：", 1020, 30);
        drawTank(1020,60,g,0,0);
        g.setColor(Color.BLACK);
        g.drawString("" + Result.achievement,1080,100);
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * 监控键盘按下事件
     *
     * @param e 键盘事件
     */
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
        if (e.getKeyCode() == KeyEvent.VK_J)
            hero.shotEnemyTank();
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * 重绘画板线程，每隔50毫秒
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}
