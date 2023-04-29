package com.hspedu.qqcommon;

import java.io.Serializable;

/**
 * 表示客户端和服务端传输的消息对象
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 4663089470380193050L;
    private String sender;  //发送者
    private String getter;  //接收者
    private String content; //消息内容
    private String sendTime;    //发送时间
    private String mesType; //消息类型[可以在接口定义消息类型]

    //文件相关
    private byte[] bytes;   //文件字节数组
    private int fileLength; //文件大小
    private String senMath;
    private String getMath;

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public int getFileLength() {
        return fileLength;
    }

    public void setFileLength(int fileLength) {
        this.fileLength = fileLength;
    }

    public String getSenMath() {
        return senMath;
    }

    public void setSenMath(String senMath) {
        this.senMath = senMath;
    }

    public String getGetMath() {
        return getMath;
    }

    public void setGetMath(String getMath) {
        this.getMath = getMath;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }
}
