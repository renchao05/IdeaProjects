package com.hspedu.tankgame3;


import java.util.List;
import java.util.Vector;

/**
 * 自己的坦克
 */
public class Hero extends Tank {
    public  List<Shot> shots = new Vector<>();
    private Shot shot = null;
    public Hero(int x, int y) {
        super(x, y);
    }

    public Shot getShot() {
        return shot;
    }

    //子弹发射
    public void shotEnemyTank() {
        //创建一个子弹
        switch (this.getDirect()) {
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
}
