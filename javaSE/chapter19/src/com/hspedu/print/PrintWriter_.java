package com.hspedu.print;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriter_ {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(System.out);
        pw.write("任超，您好====");  //打印到显示器

        pw = new PrintWriter("d:\\print.txt");
        pw.println("任超你号，哈哈！！！！");
        pw.close();
    }
}
