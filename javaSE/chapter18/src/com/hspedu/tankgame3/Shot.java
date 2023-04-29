package com.hspedu.tankgame3;

public class Shot implements Runnable{
    private int x;  //坦克横坐标
    private int y;  //坦克纵坐标
    private int speed = 5; //速度
    private int direct; //方向0 1 2 3 4
    private boolean state = true;   //子弹状态

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

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true) {
            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1: //向右
                    x += speed;
                    break;
                case 2: //向下
                    y += speed;
                    break;
                case 3: //向左
                    x -= speed;
                    break;
                default:
                    System.out.println("暂时没有处理");
            }
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +"坐标：" + x + " + " + y + "。。。方向：" + direct);
            if (x > 1000 || x < 0 || y > 750 || y < 0) {
                System.out.println("子弹消失。。");
                state = false;
                break;
            }
        }
    }
}
