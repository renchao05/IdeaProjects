package com.hspedu.tankgame2;

import javax.swing.*;

public class HspTankGame01 extends JFrame {

    //定义一个面板MyPanel
    MyPanel mp = null;

    public static void main(String[] args) {
        HspTankGame01 hspTankGame01 = new HspTankGame01();
    }

    public HspTankGame01() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
