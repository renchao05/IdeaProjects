package com.hspedu.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("等待连接。。。。");
        Socket accept = serverSocket.accept();
        System.out.println("连接成功！！！！！");

        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        System.out.println(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("你好，客户端，我是服务端，我已经收到你的信息了！！！！！！！！！！！！");
        bw.newLine();
        bw.flush();
//        accept.shutdownOutput();
        serverSocket.close();
        accept.close();
        br.close();
        bw.close();
    }
}
