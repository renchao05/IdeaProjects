package com.hspedu.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Homework02A {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] b = new byte[1024];
        DatagramPacket packet = new DatagramPacket(b, b.length);
        System.out.println("等待接受数据。。。");
        socket.receive(packet);
        String s = new String(packet.getData(), 0, packet.getLength());
        System.out.println(s);
        byte[] bytes1 = "红楼梦，水浒传".getBytes();
        byte[] bytes2 = "说的什么？".getBytes();
        if ("四大名著有哪些？".equals(s))
            packet.setData(bytes1,0, bytes1.length);
        else
            packet.setData(bytes2,0, bytes2.length);
        socket.send(packet);

        socket.close();

    }
}
