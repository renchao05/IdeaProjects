package com.renchao.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("sss.properties");
        properties.load(inputStream);
        String user = properties.getProperty("user","555");
        String password = properties.getProperty("password", "555");
        String ccc = properties.getProperty("ccc", "555");
        System.out.println(user);
        System.out.println(password);
        System.out.println(ccc);
        ArrayList list = new ArrayList();
        list.add(null);
        list.add(123);
        System.out.println(list);
    }
}
