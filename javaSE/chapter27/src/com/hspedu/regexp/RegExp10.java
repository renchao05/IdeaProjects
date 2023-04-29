package com.hspedu.regexp;

import com.hspedu.Utility;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp10 {
    public static void main(String[] args) {
        while (true) {
            System.out.println("请输入汉字：");
            String content = Utility.readString(100);
            Pattern compile = Pattern.compile("^[\\u4E00-\\u9FA5]+$");
            Matcher matcher = compile.matcher(content);
            if (matcher.find()) {
                System.out.println("输入正确。。。。");
                break;
            }
            else
                System.out.println("输入错误");
        }
    }

    //验证邮编
    @Test
    public void test1() {
        String content = "122222";
        Pattern compile = Pattern.compile("^[1-9]\\d{5}$");
        //创建匹配器，按照正则表达式的规则
        Matcher matcher = compile.matcher(content);
        boolean b = false;
        if (matcher.find())
            System.out.println("输入正确!!!");
        else {
            System.out.println("输入错误。。。。");
        }
    }

    //验证QQ
    @Test
    public void test2() {
        String content = "02220000000";
        Pattern compile = Pattern.compile("^[1-9]\\d{4,9}$");
        //创建匹配器，按照正则表达式的规则
        Matcher matcher = compile.matcher(content);
        boolean b = false;
        if (matcher.find())
            System.out.println("输入正确!!!");
        else {
            System.out.println("输入错误。。。。");
        }
    }
    //验证手机号
    @Test
    public void test3() {
        String content = "15220000009";
        Pattern compile = Pattern.compile("^1[3458]\\d{9}$");
        //创建匹配器，按照正则表达式的规则
        Matcher matcher = compile.matcher(content);
        boolean b = false;
        if (matcher.find())
            System.out.println("输入正确!!!");
        else {
            System.out.println("输入错误。。。。");
        }
    }

    //验证url
    @Test
    public void test4() {
        String content = "https://www.bilibili.com/bangumi/play/ep428988?spm_id_from=333.1007.0.0";
        Pattern compile = Pattern.compile("^((https|http)://)([\\w-]+\\.)+[a-zA-Z]+(\\/[\\w#-@=]*)?$");
        //创建匹配器，按照正则表达式的规则
        Matcher matcher = compile.matcher(content);
        boolean b = false;
        if (matcher.find())
            System.out.println("输入正确!!!");
        else {
            System.out.println("输入错误。。。。");
        }
    }
}
