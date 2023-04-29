package com.hspedu.homework;

import java.io.IOException;
import java.net.*;

public class Homework02B {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9988);
        byte[] b = "四大名著有哪些？".getBytes();
        DatagramPacket packet = new DatagramPacket(b, 0, b.length,
                InetAddress.getByName("192.168.10.189"), 9999);
        socket.send(packet);

        socket.receive(packet);
        System.out.println(new String(packet.getData(),0, packet.getLength()));

        socket.close();
        System.out.println("程序结束");
    }
}
