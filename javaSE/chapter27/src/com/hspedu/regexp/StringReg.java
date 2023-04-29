package com.hspedu.regexp;

public class StringReg {
    public static void main(String[] args) {
        String str = "2000 年 5 月，JDK1.3、JDK1.4 和 J2SE1.3 相继发布，几周后其" +
                "获得了 Apple 公司 Mac OS X 的工业标准的支持。2001 年 9 月 24 日，J2EE1.3 发" +
                "布。2002 年 2 月 26 日，J2SE1.4 发布。自此 Java 的计算能力有了大幅提升";
        //使用正则表达式方式，将 JDK1.3 和 JDK1.4 替换成 JDK
        str = str.replaceAll("JDK1\\.3|JDK1\\.4", "JDK");
        System.out.println(str);

        //要求验证一个 手机号， 要求必须是以 138 139 开头的
        str = "13888889999";
        if (str.matches("1(38|39)\\d{8}")) {
            System.out.println("验证成功");
        } else {
            System.out.println("验证失败");
        }

        //要求按照 # 或者 - 或者 ~ 或者 数字 来分割
        System.out.println("===================");
        str = "hello#abc-jack12smith~北京";
        String[] split = str.split("#|-|~|\\d+");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
