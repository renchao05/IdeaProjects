package com.hspedu.work;

import java.util.Arrays;
import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) {
        String[] user = new String[3];
        try {
            user = register();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(Arrays.toString(user));
    }

    public static String[] register() {
        Scanner scanner = new Scanner(System.in);
        String[] user = new String[3];
        System.out.print("请输入用户名：");
        user[0] = scanner.next();
        System.out.print("请输入密码：");
        user[1] = scanner.next();
        System.out.print("请输入邮箱：");
        user[2] = scanner.next();
        if (!(user[0].length() >= 2 && user[0].length() <= 4)) {
            throw new RuntimeException("用户名输入错误，长度2-4个字符！");
        } else if(!(user[1].length() == 6 && judge(user[1]))) {
            throw new RuntimeException("请输入6位数字！");
        } else if (!(user[2].indexOf("@") > 0 && user[2].indexOf(".") - user[2].indexOf("@") > 0)) {
            throw new RuntimeException("邮箱输入错误！");
        }
        return user;
    }

    public static boolean judge(String str) {
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] < '0' || chs[i] > '9')
                return false;
        }
        return true;
    }
}
