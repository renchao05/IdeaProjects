package com.hspedu.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        //零钱通明细变量
        String details = "-------------------零钱通明细--------------------\n";

        //收益变量
        double money = 0;
        double balance = 0;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //日期格式化

        //消费变量
        String note = "";//消费原因
        do {
            System.out.println("==========零钱通菜单==========");
            System.out.println("\t\t\t\t1 零钱通明细");
            System.out.println("\t\t\t\t2 收益");
            System.out.println("\t\t\t\t3 消费");
            System.out.println("\t\t\t\t4 退     出");

            System.out.print("请选择(1-4):");
            key = scanner.next();

            switch (key) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.print("收益入账金额：");
                    money = scanner.nextDouble();
                    if (money <= 0) {
                        System.out.println("金额请大于0。。。");
                        break;
                    }
                    balance += money;
                    date = new Date();
                    //System.out.println(sdf.format(date));
                    details += "入账\t+" + money + "\t" + sdf.format(date) + "\t余额" + balance + "元\n";
                    break;
                case "3":
                    System.out.print("消费金额：");
                    money = scanner.nextDouble();
                    if (money <= 0 || money > balance) {
                        System.out.println("请输入金额0-" + balance + "元。");
                        break;
                    }
                    System.out.print("消费原因：");
                    note = scanner.next();
                    balance -= money;
                    date = new Date();
                    //System.out.println(sdf.format(date));
                    details += note + "\t-" + money + "\t" + sdf.format(date) + "\t余额" + balance + "元\n";
                    break;
                case "4":
                    System.out.println("你确定要退出吗？y/n");
                    while (true) {
                        key = scanner.next();
                        //System.out.println(key);
                        if (key.equals("y")) {
                            loop = false;
                            break;
                        } else if (key.equals("n")) {
                            break;
                        } else {
                            System.out.println("输入错误，请输入:y/n");
                        }
                    }
                    break;
                default:
                    System.out.println("菜单选择有误，请重新选择。");
            }
        } while (loop);
        System.out.println("退出了零钱通。。。");
    }
}
