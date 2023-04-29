package com.hspedu.try_;

import java.util.Scanner;

public class EcmDef {
    public static void main(String[] args) {
        System.out.print("请输入被除数：");
        int n1 = next();
        System.out.print("请输入除数：");
        int n2 = next();
        System.out.println("计算结果：" + cal(n1,n2));
    }

    public static int cal(int n1, int n2) {
        try {
            return n1 / n2;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int next() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.print("输入错误，请重新输入：");
            return next();
        }
    }
}
