package com.hspedu.regexp;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework01 {
    public static void main(String[] args) {
        String content = "22-2s@qq.com";
        boolean matches = content.matches("[\\w-]+@[a-zA-Z]+(\\.[a-zA-Z]+)+");
        System.out.println(matches ? "正确" : "错误");
    }

    @Test
    public void test() {
        String content = "c12c3abc";
        //创建模式对象【即正则表达式对象】
        Pattern compile = Pattern.compile("\\w+");

        //创建匹配器，按照正则表达式的规则
        Matcher matcher = compile.matcher(content);

        while (matcher.find()) {
            System.out.print(matcher.group(0) + "=");
        }
    }
}


