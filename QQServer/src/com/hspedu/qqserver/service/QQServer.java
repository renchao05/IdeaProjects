package com.hspedu.qqserver.service;


import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 这是服务器，监听9999端口，等待客户端连接，并保持通讯
 */
public class QQServer {
    private ServerSocket ss = null;
    private static HashMap<String,User> hm = new HashMap<>();

    static {
        hm.put("100",new User("100","123456"));
        hm.put("101",new User("101","123456"));
        hm.put("102",new User("102","123456"));
        hm.put("至尊宝",new User("至尊宝","123456"));
        hm.put("紫霞仙子",new User("紫霞仙子","123456"));
        hm.put("菩提老祖",new User("菩提老祖","123456"));
    }

    private boolean checkUser(String userId, String passwd) {
        if (hm.get(userId) == null)
            return false;
        else if (!hm.get(userId).getPasswd().equals(passwd))
            return false;
        return true;
    }

    public QQServer() {
        System.out.println("服务器正在9999端口监听。。。");
        new QQPush().start();
        try {
            ss = new ServerSocket(9999);
            while (true) {
                Socket socket = ss.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User user = (User) ois.readObject();
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Message message = new Message();
                if (checkUser(user.getUserId(),user.getPasswd())) {
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    oos.writeObject(message);
                    ServerConnectClient scc = new ServerConnectClient(socket, user.getUserId());
                    scc.start();    //开启线程
                    ManageClientThreads.addServerConnectClient(user.getUserId(),scc);   //线程加入集合

                    if (ManageClientThreads.getRecord().containsKey(user.getUserId())) {
                        LinkedHashSet<Message> messages = ManageClientThreads.getMessage(user.getUserId());
                        for (Message m : messages) {
                            ObjectOutputStream oos2 = new ObjectOutputStream(socket.getOutputStream());
                            oos2.writeObject(m);
//                            oos2.close();
                        }
                        ManageClientThreads.getRecord().remove(user.getUserId());
                    }
                    //ois,oos 应该也需要关闭的，老师没有说，后面自己进行测试
                }
                else {
                    System.out.println("登陆失败。。。");
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    oos.close();
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
