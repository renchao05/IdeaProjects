package com.hspedu.qqserver.service;

import com.hspedu.qqcommon.Message;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class ManageClientThreads {
    private static final HashMap<String,ServerConnectClient> hm = new HashMap<>();
    private static final HashMap<String, LinkedHashSet<Message>> record = new HashMap<>();

    public static HashMap<String, ServerConnectClient> getHm() {
        return hm;
    }

    public static void addRecord(String getter, LinkedHashSet<Message> messages) {
        record.put(getter,messages);
    }

    public static HashMap<String, LinkedHashSet<Message>> getRecord() {
        return record;
    }

    public static LinkedHashSet<Message> getMessage(String getter) {
        return record.get(getter);
    }

    public static void addServerConnectClient(String userId, ServerConnectClient serverConnectClient) {
        hm.put(userId,serverConnectClient);
    }

    public static void remove(String userId) {
        hm.remove(userId);
    }

    public static ServerConnectClient getServerConnectClient(String userId) {
        return hm.get(userId);
    }

    public static String getUserList() {
        String s = "";
        for (String s1 : hm.keySet()) {
            s +=s1 + " ";
        }
        return s;
    }
}
