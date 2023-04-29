package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework03 {
    public static void main(String[] args) {
        String content = "http://www.sohu.com:8080/abc/index.htm";
        /**
         * 协议 http
         * 域名www.sohu.com
         * 端口
         * 文件名 index.htm
         */
        //创建模式对象【即正则表达式对象】
        //协议
//        Pattern compile = Pattern.compile("([a-z]+)://");
        //域名
//        Pattern compile = Pattern.compile("//(([\\w-_]+\\.)+[a-z]+)");
        //端口
//        Pattern compile = Pattern.compile(":(\\d{1,5})");
        //文件名
        Pattern compile = Pattern.compile("\\w+(.\\w+)$");
        //创建匹配器，按照正则表达式的规则
        Matcher matcher = compile.matcher(content);

        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }
}
