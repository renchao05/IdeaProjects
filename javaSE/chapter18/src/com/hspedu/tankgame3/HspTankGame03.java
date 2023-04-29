package com.hspedu.tankgame3;

import javax.swing.*;

public class HspTankGame03 extends JFrame {

    //定义一个面板MyPanel
    MyPanel mp = null;

    public static void main(String[] args) {
        HspTankGame03 hspTankGame03 = new HspTankGame03();
    }

    public HspTankGame03() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        new Thread(mp).start();
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
