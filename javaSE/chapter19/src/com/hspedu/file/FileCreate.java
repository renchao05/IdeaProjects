package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
//    public static void main(String[] args) {
//
//    }

    @Test
    public void create01() {
        String filePath = "d:\\news1.txt";
        File file = new File(filePath);
        try {
            boolean newFile = file.createNewFile();
            System.out.println("文件创建成功。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void create02() {
        File parentFile = new File("e:\\");
        String fileName = "news2.txt";
        //这里的 file 对象，在 java 程序中，只是一个对象
        //只有执行了 createNewFile 方法，才会真正的，在磁盘创建该文件
        File file =  new File(parentFile, fileName);
        try {
            boolean newFile = file.createNewFile();
            System.out.println("文件2创建成功。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void create03() {
        String path = "d:\\";
        String filePath = "KEFU\\news3.txt";
        File file = new File(path, filePath);
        try {
            System.out.println(file.createNewFile());
            System.out.println("文件3创建成功。");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件创建失败。");
        }
    }
}

