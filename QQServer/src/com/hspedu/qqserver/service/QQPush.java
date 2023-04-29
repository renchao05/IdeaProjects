package com.hspedu.qqserver.service;

import com.hspedu.qqcommon.Message;
import com.hspedu.qqcommon.MessageType;
import com.hspedu.qqcommon.Utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Set;

public class QQPush extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("请输入你要推送的内容：");
            String content = Utility.readString(100);
            Message message = new Message();
            message.setSender("服务器");
            message.setContent(content);
            message.setMesType(MessageType.MESSAGE_COMM_MES);
            if (ManageClientThreads.getHm() != null) {
                Set<String> strings = ManageClientThreads.getHm().keySet();
                for (String s : strings) {
                    if (!message.getSender().equals(s)) {
                        try {
                            ObjectOutputStream oos = new ObjectOutputStream(ManageClientThreads.getServerConnectClient(s).getSocket().getOutputStream());
                            oos.writeObject(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
