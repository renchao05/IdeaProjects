package com.hspedu.api_;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        InetAddress byName = InetAddress.getByName("DESKTOP-8C6I95U");
        System.out.println(byName);
        InetAddress byName1 = InetAddress.getByName("www.baidu.com");
        System.out.println(byName1);
        System.out.println("============================");
        String hostName = byName1.getHostName();
        System.out.println(hostName);
        String hostAddress = byName1.getHostAddress();
        System.out.println(hostAddress);
    }
}
