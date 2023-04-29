package com.hspedu.regexp;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTheory {
    public static void main(String[] args) {
        String content = "c12c3abc";

        //创建模式对象【即正则表达式对象】
        Pattern compile = Pattern.compile("c\\B");

        //创建匹配器，按照正则表达式的规则
        Matcher matcher = compile.matcher(content);

        while (matcher.find()) {
            System.out.print(matcher.group(0));
        }
    }

    @Test
    public void test01() {
        String content = "1998 年 12 月 8 日，第二代 Java 平台的企业版 J2EE 发布。1999 年 6 月，Sun 公司发布了" +
                "第二代 Java 平台（简称为 Java2）的 3 个版本：J2ME（Java2 Micro Edition，Java2 平台的微型" +
                "版），应用于移动、无线及有限资源的环境；J2SE（Java 2 Standard Edition，Java 2 平台的" +
                "标准版），应用于桌面环境；J2EE（Java 2Enterprise Edition，Java 2 平台的企业版），应" +
                "用 3443 于基于 Java 的应用服务器。Java 2 平台的发布，是 Java 发展过程中最重要的一个" +
                "里程碑，标志着 Java 的应用开始普及 9889 ";

        //1. 正则表达式
        String regStr = "(\\d\\d)(\\d\\d)";
        //2. 创建模式对象[即正则表达式对象]
        Pattern pattern = Pattern.compile(regStr);
        //3. 创建匹配器
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到: " + matcher.group(0));
            System.out.println("第 1 组()匹配到的值=" + matcher.group(1));
            System.out.println("第 2 组()匹配到的值=" + matcher.group(2));
        }
    }
}
