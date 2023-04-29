package com.hspedu.regexp;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework02 {
    public static void main(String[] args) {
        String content = "01.08";
        //0.3 15.66 -56.3 -55
//        String regStr1 = ""
        boolean matches = content.matches("[-+]?([1-9]\\d*|0)\\.?\\d+");
        System.out.println(matches ? "正确" : "错误");
    }

    @Test
    public void test() {
        String content = "c1---2c-3ab-c";
        //创建模式对象【即正则表达式对象】
        Pattern compile = Pattern.compile("-+");

        //创建匹配器，按照正则表达式的规则
        Matcher matcher = compile.matcher(content);

        while (matcher.find()) {
            System.out.print(matcher.group(0) + "=");
        }
    }
}
