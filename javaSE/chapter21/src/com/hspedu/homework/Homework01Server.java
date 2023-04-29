package com.hspedu.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Homework01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("等待连接。。。");
        Socket accept = serverSocket.accept();
        System.out.println("连接成功。。");
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        String next = "";
        while (!("不问了".equals(next))) {
            next = br.readLine();
            System.out.println(next);
            if (next.equals("name"))
                bw.write("我是任超！");
            else if (next.equals("hobby"))
                bw.write("编写java程序。");
            else
                bw.write("你说的什么东西？？？");
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
        accept.close();
        serverSocket.close();
        System.out.println("程序结束。。。");
    }
}
