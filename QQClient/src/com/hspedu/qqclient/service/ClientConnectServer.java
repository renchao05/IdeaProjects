package com.hspedu.qqclient.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.HashMap;

/**
 * 客户端连接服务端的线程
 */
public class ClientConnectServer extends Thread {
    private Socket socket;
    private boolean b = true;
    public HashMap<String, String> hm = new HashMap<>();

    public ClientConnectServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (b) {
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
                    String[] s = message.getContent().split(" ");
                    System.out.println("\n=============在线用户列表=============");
                    for (int i = 0; i < s.length; i++) {
                        hm.put("" + (i + 1), s[i]);
                        System.out.println(s[i]);
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {  //备用，自己想的，不删除也没有影响
                    ManageCSThread.remove(message.getGetter()); //备用，自己想的，不删除也没有影响
                    b = false;  //备用，自己想的，不删除也没有影响
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    System.out.println("\n"+ message.getSender() + " 给您发来消息：" + message.getContent());
                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    System.out.println("\n"+ message.getSender() + " 给您发来文件：" + message.getContent() + "\n保存在：" + message.getGetMath());
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(message.getGetMath()));
                    bos.write(message.getBytes());
                    bos.close();
                } else
                    System.out.println("其他情况，后面解决。。。");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
