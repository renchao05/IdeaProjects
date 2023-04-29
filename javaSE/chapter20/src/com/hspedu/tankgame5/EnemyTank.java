package com.hspedu.tankgame5;

import java.io.Serializable;

public class EnemyTank extends Tank implements Runnable, Serializable {

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    /**
     * 坦克自由移动，并且随机发射子弹
     */
    @Override
    public void run() {
        while (state) {
            //随机移动小于20步
            for (int i = 0; i < (int) (Math.random() * 20); i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                switch (getDirect()) {
                    case 0:
                        moveUp();
                        break;
                    case 1:
                        moveRight();
                        break;
                    case 2:
                        moveDown();
                        break;
                    case 3:
                        moveLeft();
                        break;
                }
                //随机发射子弹，最多只能同时发5颗
                if ((int) (Math.random() * 5) == 0)
                    shotEnemyTank();
            }
            //随机改变方向
            setDirect((int) (Math.random() * 4));
        }
    }
}
