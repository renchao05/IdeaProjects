package com.hspedu.tankgame5;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class Node implements Serializable {
    public int x;  //坦克横坐标
    public int y;  //坦克纵坐标
    public int direct; //方向0 1 2 3 4
    public List<Node> enemy = new Vector<>();

    public Node(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public Node() {
        for (Tank tank : MyPanel.enemyTank) {
            enemy.add(new Node(tank.x, tank.y,tank.getDirect()));
        }
    }
}
