package com.hspedu.qqclient.view;

import com.hspedu.qqclient.service.ManageCSThread;
import com.hspedu.qqclient.service.PrivateChat;
import com.hspedu.qqclient.service.UserClientService;
import com.hspedu.qqclient.utils.Utility;
import com.hspedu.qqcommon.User;

import java.util.Map;
import java.util.Set;

/**
 * 客户端菜单界面
 */
public class QQView {
    private boolean loop = true;
    private String key;
    private UserClientService userClientService = new UserClientService();
    private PrivateChat privateChat =new PrivateChat();
    private User user;


    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("退出系统。。");
    }

    private void mainMenu() {
        while (loop) {
            System.out.println("=============欢迎登陆网络通信系统=============");
            System.out.println("\t\t\t\t1 登陆系统\n\t\t\t\t9 退出系统");
            System.out.print("请输入您的选择：");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.print("请输入账户：");
                    String userId = Utility.readString(20);
                    System.out.print("请输入密码：");
                    String passwd = Utility.readString(20);
                    user = new User(userId, passwd);
                    if (userClientService.checkUser(user)) {
                        while (loop) {
                            System.out.println("=============欢迎" + userId + "登陆成功=============");
                            System.out.println("\t\t\t\t1 显示在线用户列表");
                            System.out.println("\t\t\t\t2 群发消息");
                            System.out.println("\t\t\t\t3 私发消息");
                            System.out.println("\t\t\t\t4 发送文件");
                            System.out.println("\t\t\t\t9 退出系统");
                            System.out.print("请输入您的选择：");
                            key = Utility.readString(1);

                            switch (key) {
                                case "1":
                                    userClientService.onlineFriendList();
                                    try {
                                        Thread.sleep(100);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case "2":
                                    privateChat.chat(user.getUserId());
                                    System.out.println("群发消息");
                                    break;
                                case "3":
                                    System.out.println("=============在线用户列表=============");
                                    Set<Map.Entry<String, String>> entries = ManageCSThread.hm.get(user.getUserId()).hm.entrySet();
                                    for (Map.Entry<String, String> s : entries) {
                                        System.out.println(s.getKey() + ":" + s.getValue());
                                    }
                                    System.out.print("输入用户序列号：");
                                    String s = Utility.readString(1);
                                    String getter = ManageCSThread.hm.get(user.getUserId()).hm.get(s);
                                    privateChat.chat(user.getUserId(),getter);
                                    break;
                                case "4":
                                    System.out.println("=============在线用户列表=============");
                                    Set<Map.Entry<String, String>> entries2 = ManageCSThread.hm.get(user.getUserId()).hm.entrySet();
                                    for (Map.Entry<String, String> s2 : entries2) {
                                        System.out.println(s2.getKey() + ":" + s2.getValue());
                                    }
                                    System.out.print("输入用户序列号：");
                                    String s2 = Utility.readString(1);
                                    String getter2 = ManageCSThread.hm.get(user.getUserId()).hm.get(s2);
                                    System.out.print("输入要发送的文件：");
                                    String senMath = Utility.readString(100);
                                    System.out.print("输入对方路径：");
                                    String getMath = Utility.readString(100);
                                    privateChat.sendFiles(userId,getter2,senMath,getMath);
                                    System.out.println("发送文件");
                                    break;
                                case "9":
                                    loop = false;
                                    userClientService.exit();
                                    break;

                            }
                        }
                    } else {
                        System.out.println("===登陆失败===");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
    }
}
