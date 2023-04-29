package com.hspedu.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDP_A {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] b = new byte[1024];
        DatagramPacket packet = new DatagramPacket(b, b.length);
        System.out.println("等待接受数据。。。");
        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));

        //回复
        packet.setData("好的，晚上见！！".getBytes());
        socket.send(packet);

        socket.close();
        System.out.println("A端退出。。。");

    }
}
