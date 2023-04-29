package com.hspedu.tankgame3;

public class enemyShot implements Runnable{
    private EnemyTank enemyTank;
    @Override
    public void run() {
        enemyTank.shotTank();
    }
}
