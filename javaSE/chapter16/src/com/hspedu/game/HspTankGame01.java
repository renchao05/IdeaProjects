package com.hspedu.game;

import javax.swing.*;

public class HspTankGame01 extends JFrame {
    private MyPanel mp = null;

    public static void main(String[] args) {
        new HspTankGame01();
    }

    public HspTankGame01() {
        mp = new MyPanel();
        this.add(mp);////把面板放入到窗口（画框）
        this.setSize(450,320);//设置窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭程序
        this.setVisible(true); //让程序可见
    }
}
