package com.hspedu.socket;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在 9999 端口监听，等待连接....");
        Socket accept = serverSocket.accept();
        System.out.println("服务端收到连接：" + accept.getClass());
        System.out.println("===========下面内容是传输过来的===============");

        InputStream is = accept.getInputStream();
        int len = 0;
        byte[] buf = new byte[1024];
        while ((len = is.read(buf)) != -1) {
            System.out.println(new String(buf,0,len));
        }


        OutputStream os = accept.getOutputStream();
        os.write("你好，任超的客户端，我是服务端，我收到你的信息了。。。。".getBytes());
        accept.shutdownOutput();
        serverSocket.close();
        accept.close();
        is.close();
        os.close();
    }
}
