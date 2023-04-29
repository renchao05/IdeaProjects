package com.hspedu.tankgame4;

import javax.swing.*;

public class HspTankGame04 extends JFrame {

    //定义一个面板MyPanel
    MyPanel mp = null;

    public static void main(String[] args) {
        HspTankGame04 hspTankGame04 = new HspTankGame04();
    }

    /**
     * 初始化
     */
    public HspTankGame04() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        new Thread(mp).start();
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
