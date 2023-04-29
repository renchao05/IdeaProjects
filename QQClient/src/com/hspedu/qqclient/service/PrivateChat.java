package com.hspedu.qqclient.service;

import com.hspedu.qqclient.utils.Utility;
import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;

import java.io.*;

public class PrivateChat extends Thread{

    public void chat(String userId, String getter) {
        System.out.print("输入要发送的内容：");
        String content = Utility.readString(100);
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSender(userId);
        message.setGetter(getter);
        message.setContent(content);
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageCSThread.getClientConnectServer
                            (userId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void chat(String userId) {
        System.out.print("输入要发送的内容：");
        String content = Utility.readString(100);
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSender(userId);
        message.setGetter("all");
        message.setContent(content);
        try {
            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageCSThread.getClientConnectServer
                            (userId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendFiles(String userId, String getter,String senMath,String getMath) {
        Message message = new Message();
        message.setSender(userId);
        message.setGetter(getter);
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSenMath(senMath);
        message.setGetMath(getMath);
        byte[] b = new byte[(int)new File(senMath).length()];
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(senMath));
            message.setFileLength(bis.read(b));
            message.setBytes(b);

            ObjectOutputStream oos = new ObjectOutputStream
                    (ManageCSThread.getClientConnectServer
                            (userId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
