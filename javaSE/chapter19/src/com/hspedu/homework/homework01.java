package com.hspedu.homework;

import java.io.*;

public class homework01 {
    public static void main(String[] args) throws IOException {
        String math = "d:\\mytemp";
        File file = new File(math);
        if (!file.exists())
            file.mkdirs();
        math = math + "\\hello.txt";
        File file1 = new File(math);
        if (file1.exists())
            System.out.println("文件已经存在！！");
        else
            file1.createNewFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(math));
        bw.write("hello,world!!!");
        bw.close();

    }
}
