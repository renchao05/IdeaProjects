package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.File;

public class Directory {

    @Test
    public void m1() {
        String filePath = "d:\\news1.txt";
        File file = new File(filePath);
        if (file.exists())
            if (file.delete())
                System.out.println("news1.txt删除成功。");
            else
                System.out.println("删除失败！！");
        else
            System.out.println("文件不存在！！");
    }

    @Test
    public void m2() {
        String filePath = "d:\\demo02";
        File file = new File(filePath);
        if (file.exists())
            if (file.delete())
                System.out.println("demo02删除成功。");
            else
                System.out.println("删除失败！！");
        else
            System.out.println("文件不存在！！");
    }

    @Test
    public void m3() {
        String filePath = "d:\\demo02\\a\\b\\e";
        File file = new File(filePath);
        if (file.exists())
            System.out.println("目录已存在！");
        else
            if (file.mkdirs())
                System.out.println("文件创建成功。");
            else
                System.out.println("文件创建失败！！！");
    }
}
