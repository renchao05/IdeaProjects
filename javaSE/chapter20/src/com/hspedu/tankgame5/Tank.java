package com.hspedu.tankgame5;

import java.util.List;
import java.util.Vector;

public class Tank {
    public int x;  //坦克横坐标
    public int y;  //坦克纵坐标
    private int direct; //方向0 1 2 3 4
    private int speed = 5;   //移动系数，快慢
    public boolean state = true;    //坦克状态
    private Shot shot = null;
    public List<Shot> shots = new Vector<>();
    private List<Tank> tank2 = new Vector<>();

    //子弹发射
    public void shotEnemyTank() {
        //创建一个子弹
        if (shots.size() >= 5)
            return;
        switch (this.direct) {
            case 0: //向上
                this.shot = new Shot(this.getX() + 18, this.getY() - 5, 0);
                break;
            case 1: //向右
                this.shot = new Shot(this.getX() + 62, this.getY() + 18, 1);
                break;
            case 2: //向下
                this.shot = new Shot(this.getX() + 18, this.getY() + 62, 2);
                break;
            case 3: //向左
                this.shot = new Shot(this.getX() - 5, this.getY() + 18, 3);
                break;
            default:
                System.out.println("暂时没有处理");
        }
        shots.add(shot);
        new Thread(shot).start();
    }

    /**
     * 坦克中心坐标
     */
    public int oX() {
        return x + width() / 2;
    }

    public int oY() {
        return y + high() / 2;
    }

    /**
     * 坦克的宽高
     */

    public int width() {
        return endX() - x;
    }

    public int high() {
        return endY() - y;
    }

    /**
     * 坦克结束位置坐标
     *
     * @return 坐标
     */
    public int endX() {
        if (direct == 0 || direct == 2)
            return x + 40;
        return x + 60;
    }

    public int endY() {
        if (direct == 0 || direct == 2)
            return y + 60;
        return y + 40;
    }

    /**
     * @return 坦克装到一个集合
     */
    public void packTank() {
        tank2.clear();
        if (MyPanel.enemyTank != null)
            tank2.addAll(MyPanel.enemyTank);
        if (MyPanel.hero != null)
            tank2.add(MyPanel.hero);
    }


    /**
     * 坦克移动方法
     */
    public void moveUp() {
        packTank();
        for (Tank tank : tank2) {
            if (this != tank)
                if (this.y <= tank.endY() + 5 && this.endY() >= tank.endY() && this.endX() >= tank.x && this.x <= tank.endX())
                    return;
        }
        if (y > 0)
            y -= speed;
    }

    public void moveDown() {
        packTank();
        for (Tank tank : tank2) {
            if (this != tank)
                if (this.y <= tank.y && this.endY() >= tank.y - 5 && this.endX() >= tank.x && this.x <= tank.endX())
                    return;
        }
        if (y < 690)
            y += speed;
    }

    public void moveLeft() {
        packTank();
        for (Tank tank : tank2) {
            if (this != tank)
                if (this.y <= tank.endY() && this.endY() >= tank.y && this.endX() >= tank.endX() && this.x <= tank.endX() + 5)
                    return;
        }
        if (x > 0)
            x -= speed;
    }

    public void moveRight() {
        packTank();
        for (Tank tank : tank2) {
            if (this != tank)
                if (y <= tank.endY() && this.endY() >= tank.y && this.endX() >= tank.x - 5 && this.x <= tank.x)
                    return;
        }
        if (x < 940)
            x += speed;
    }

    public Shot getShot() {
        return shot;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
