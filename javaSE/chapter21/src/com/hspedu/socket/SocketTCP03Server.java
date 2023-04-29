package com.hspedu.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("正在等待连接。。。。");
        Socket accept = serverSocket.accept();
        System.out.println("连接成功！！");
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:\\Desktop.zip"));
        int len;
        byte[] but = new byte[1024];
        while ((len = bis.read(but)) != -1) {
            bos.write(but,0,len);
        }
        bos.flush();
        System.out.println("文件接受完毕。");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("收到图片了，谢谢！");
        bw.newLine();
        bw.flush();

        bw.close();
        bos.close();
        bis.close();
        accept.close();
        serverSocket.close();
    }
}
