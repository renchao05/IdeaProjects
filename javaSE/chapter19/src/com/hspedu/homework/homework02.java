package com.hspedu.homework;

import java.io.*;

public class homework02 {
    public static void main(String[] args) throws IOException {
        String str = "";
        InputStreamReader isr = new InputStreamReader(new FileInputStream("d:\\chao.txt"),"gbk");
        BufferedReader br = new BufferedReader(isr);
        int i = 1;
        while ((str = br.readLine()) != null) {
            System.out.println(i++ + "、" + str);
        }
    }
}
