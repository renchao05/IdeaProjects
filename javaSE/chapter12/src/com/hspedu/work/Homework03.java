package com.hspedu.work;

public class Homework03 {
    public static void main(String[] args) {
        String str = "Han shun Ping";
        System.out.println(str(str));
    }

    public static String str(String str) {
        String[] strArr = str.split(" ");
        strArr[1] = strArr[1].toUpperCase();
        return strArr[2] + "," + strArr[0] + " ." + strArr[1].charAt(0);
    }
}

