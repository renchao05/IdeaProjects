package com.hspedu.tankgame5;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class HspTankGame05 extends JFrame {

    int key;

    //定义一个面板MyPanel
    MyPanel mp = null;

    public static void main(String[] args) {
        HspTankGame05 hspTankGame05 = new HspTankGame05();
    }

    /**
     * 初始化
     */
    public HspTankGame05() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字：0重新玩，1继续上次游戏");
        key = scanner.nextInt();
        mp = new MyPanel(key);
        this.add(mp);
        this.setSize(1300,800);
        new Thread(mp).start();
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //窗口关闭后调用
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Result.save();
                Result.storageResult();
                System.exit(0);
            }
        });
    }
}
