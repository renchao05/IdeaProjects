package com.hspedu.print;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream ps = System.out;
        ps.print("任超你号");
        System.setOut(new PrintStream("d:\\77.txt"));
        System.out.println("任超，你将来大有可为");

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您的名字：");
        String str = scanner.nextLine();
        System.out.println("你的名字是：" + str);
    }

    @Test
    public void test01() {
        InputStream in = System.in;
        PrintStream out = System.out;
        out.println("任超您好！！");
        out.println(in.getClass());
        out.print(out.getClass());
    }

    @Test
    public void test02() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入您的名字：");
        String str = scanner.nextLine();
        System.out.println("你的名字是：" + str);
    }

    @Test
    public void test03() throws IOException {
        PrintStream out = System.out;
        //默认是打印到显示器
        out.println("任超您好。。。");
        //源码也是使用的 write() 方法
        out.write("任超您好！！！".getBytes());

        out = new PrintStream("d:\\aa.txt");
        out.println("打印到文件：d:\\aa.txt");

        //把结果保存到文件 d:\print.txt
        System.setOut(new PrintStream("d:\\print.txt"));
        System.out.println("任超您好。。。");
        System.out.write("任超您好！！！".getBytes());

        out.close();
    }


}
