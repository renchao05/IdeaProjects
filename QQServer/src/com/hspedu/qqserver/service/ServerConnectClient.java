package com.hspedu.qqserver.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 与客户端保持通讯的线程
 */
public class ServerConnectClient extends Thread {
    private Socket socket;
    private String userId;

    //自己测试===================
    private boolean b = true;
    //自己测试===================

    public ServerConnectClient(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (b) {
            System.out.println("正在与客户端" + userId + "保持通讯。。。");
            ObjectInputStream ois = null;
            ObjectOutputStream oos = null;
            try {
                ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();

                //拉起用户列表。。。
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    oos = new ObjectOutputStream(socket.getOutputStream());
                    System.out.println(userId + "-需要拉取用户列表。");
                    message.setContent(ManageClientThreads.getUserList());
                    message.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    oos.writeObject(message);

                    //用户退出
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    oos = new ObjectOutputStream(socket.getOutputStream());
                    message.setGetter(message.getSender()); //备用，自己想的，不删除也没有影响
                    oos.writeObject(message);   //备用，自己想的，不删除也没有影响
                    b = false;
                    oos.close();
                    ois.close();
                    ManageClientThreads.remove(userId);
                    socket.close();
                    System.out.println("服务器端线程退出。。");

                    //私发消息
                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
                    if (message.getGetter().equals("all")) {
                        Set<String> strings = ManageClientThreads.getHm().keySet();
                        for (String s : strings) {
                            if (!message.getSender().equals(s)) {
                                oos = new ObjectOutputStream(ManageClientThreads.getServerConnectClient(s).getSocket().getOutputStream());
                                oos.writeObject(message);
                            }
                        }
                    } else {
                        if (ManageClientThreads.getHm().containsKey(message.getGetter())) {
                            oos = new ObjectOutputStream(ManageClientThreads.getServerConnectClient
                                    (message.getGetter()).getSocket().getOutputStream());
                            oos.writeObject(message);
                        } else { //如果离线，信息保存到集合
                            if (ManageClientThreads.getRecord().containsKey(message.getGetter())) {
                                ManageClientThreads.getMessage(message.getGetter()).add(message);
                            } else {
                                LinkedHashSet<Message> messages = new LinkedHashSet<>();
                                messages.add(message);
                                ManageClientThreads.addRecord(message.getGetter(),messages);
                            }
                        }
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE_MES)) {
                    oos = new ObjectOutputStream(ManageClientThreads.getServerConnectClient
                            (message.getGetter()).getSocket().getOutputStream());
                    oos.writeObject(message);
                }
            } catch (Exception e) {
                b = false;
                try {
                    if (oos != null)
                        oos.close();
                    if (ois != null)
                        ois.close();
                    ManageClientThreads.remove(userId);

                    if (socket != null)
                        socket.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println("服务器端线程退出。。");
//                e.printStackTrace();
            }
        }
    }
}
