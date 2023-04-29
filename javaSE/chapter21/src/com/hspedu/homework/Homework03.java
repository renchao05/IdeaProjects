package com.hspedu.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("等待连接。。。。");
        Socket accept = serverSocket.accept();
        System.out.println("连接成功1");
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        int len;
        byte[] b = new byte[1024];
        String math;
        String s = br.readLine();
        System.out.println("连接成功2");
        if (s.equals("发刊词"))
            math = "E:\\BaiduNetdiskDownload\\00发刊词.mp3";
        else if (s.equals("终点"))
            math = "E:\\BaiduNetdiskDownload\\01终点.mp3";
        else
            math = "E:\\BaiduNetdiskDownload\\02守恒.mp3";
        System.out.println("连接成功3");
        BufferedOutputStream bos = new BufferedOutputStream(accept.getOutputStream());  //把文件发送出去
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(math));   //读取本机文件
        System.out.println("连接成功，正在发送文件。。。。。。。。" + math);
        while ((len = bis.read(b)) != -1)
            bos.write(b,0,len);

        bis.close();
        bos.close();
        br.close();
        serverSocket.close();
    }
}
