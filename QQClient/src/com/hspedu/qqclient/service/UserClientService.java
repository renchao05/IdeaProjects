package com.hspedu.qqclient.service;

import com.hspedu.qqclient.utils.Utility;
import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 该类完成用户登陆和用户注册等功能
 */
public class UserClientService {
    private Socket socket;
    private User u;

    //用户登陆判断
    public boolean checkUser(User u) {
        this.u = u;
        try {
            socket = new Socket("192.168.10.189", 9999);    //连接服务器
            //User 对象传给服务器验证信息
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);
            //服务器返回验证信息
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message message = (Message)ois.readObject();
            //判断验证信息，如果登陆成功，为socket开启一个线程，并加入集合。
            if (message.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) {
                ClientConnectServer clientConnectServer = new ClientConnectServer(socket);
                ManageCSThread.addClientConnectServer(u.getUserId(),clientConnectServer);
                clientConnectServer.start();
                return true;
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //获取在线用户列表
    public void onlineFriendList() {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageCSThread.getClientConnectServer
                            (u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit() {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageCSThread.getClientConnectServer
                            (u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.exit(0); //结束进程
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
