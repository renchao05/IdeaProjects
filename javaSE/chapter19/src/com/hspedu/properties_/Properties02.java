package com.hspedu.properties_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Properties02 {
    public static void main(String[] args) throws IOException {
        Properties pr = new Properties();
//        pr.setProperty("name","renchao");
//        pr.setProperty("age","31");
//        pr.store(new FileWriter("d:\\pp.Properties"),"这里是注释！！");
        pr.load(new FileReader("d:\\pp.Properties"));
        System.out.println(pr.getProperty("name"));
        pr.list(System.out);
    }

    @Test
    public void test01() throws IOException {
        Properties ps = new Properties();
        ps.load(new FileReader("d:\\aa.txt"));
        ps.list(System.out);
        System.out.println("===========");
        System.out.println("用户名：" + ps.getProperty("user"));
        System.out.println("密码：" + ps.getProperty("password"));
    }

    @Test
    public void test02() throws IOException {
        Properties ps = new Properties();
        ps.setProperty("user", "任超");
        ps.setProperty("password", "12345");
        ps.store(new FileWriter("d:\\aa.properties"),null);
    }
}
