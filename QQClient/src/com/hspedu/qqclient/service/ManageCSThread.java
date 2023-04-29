package com.hspedu.qqclient.service;


import java.util.HashMap;

/**
 * 管理客户端到服务器的线程集合
 */
public class ManageCSThread {
    public static HashMap<String,ClientConnectServer> hm = new HashMap<>();

    //将线程加入的集合中
    public static void addClientConnectServer(String userId, ClientConnectServer connectServer) {
        hm.put(userId,connectServer);
    }

    //退出后，删除线程
    public static void remove(String userId) {
        hm.remove(userId);
    }

    //通过userId获得对应线程
    public static ClientConnectServer getClientConnectServer(String userId) {
        return hm.get(userId);
    }
}
