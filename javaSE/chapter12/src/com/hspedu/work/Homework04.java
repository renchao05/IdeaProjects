package com.hspedu.work;

public class Homework04 {
    public static void main(String[] args) {
        work("abcdzbABCZ1234567890");
    }

    public static void work(String str) {
        char[] strArr = str.toCharArray();
        int a1 = 0, a2 = 0, a3 = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] >= 'a' && strArr[i] <= 'z')
                a1++;
            else if (strArr[i] >= 'A' && strArr[i] <= 'Z')
                a2++;
            else if (strArr[i] >= '0' && strArr[i] <= '9')
                a3++;
        }
        System.out.println("小写字母数：" + a1 + "\n大写字母数：" + a2 + "\n数字数为：" + a3);
    }
}
