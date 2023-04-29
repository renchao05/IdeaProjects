package com.hspedu.buffered;

import org.junit.jupiter.api.Test;

import java.io.*;

public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String str = "ssss你好";
        InputStreamReader isr = new InputStreamReader(new FileInputStream("d:\\chao.txt"), "gbk");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d:\\chao22.txt"), "gbk");
        BufferedReader br = new BufferedReader(isr);
//        while ((br.readLine()) != null) {
        str = br.readLine();
            osw.write(str);
//        }
        br.close();
        osw.close();
    }

    @Test
    public void m4() throws IOException {
        String str = "hello!任超你号呀！！！";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d:\\chao22.txt"), "gbk");
//        BufferedWriter bw = new BufferedWriter(osw);
        osw.write("hello!任超你号呀！！！");
        osw.close();
    }

    @Test
    public void test01() {
    }
}
