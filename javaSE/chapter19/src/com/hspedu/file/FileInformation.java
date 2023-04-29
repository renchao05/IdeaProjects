package com.hspedu.file;

import java.io.File;

public class FileInformation {
    public static void main(String[] args) {
        File file = new File("D:\\KEFU\\frp_0.21.0_windows_386\\frpc.exe");
        System.out.println("文件名称：" + file.getName());
        System.out.println("绝对路径：" + file.getAbsolutePath());
        System.out.println("绝对？？？：" + file.getAbsoluteFile());
        System.out.println("父目录：" + file.getParent());
        System.out.println("文件大小(字节)：" + file.length());
        System.out.println("是否存在：" + file.exists());
        System.out.println("是否文件：" + file.isFile());
        System.out.println("是否目录：" + file.isDirectory());
    }
}

