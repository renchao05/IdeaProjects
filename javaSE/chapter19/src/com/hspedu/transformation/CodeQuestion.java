package com.hspedu.transformation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CodeQuestion {
    public static void main(String[] args) throws IOException {
        //读取 d:\\a.txt 文件编码是GBK
        //默认情况下，读取文件是按照 utf-8 编码，中文会乱码
        String filePath = "d:\\a.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String s = br.readLine();
        System.out.println("读取到的内容: " + s);
        br.close();
    }
}
