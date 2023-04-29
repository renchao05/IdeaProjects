package com.hspedu.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class Druid_ {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        System.out.println("开始连接。。。");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            Connection connection = dataSource.getConnection();
//            System.out.println(connection.getClass() + "\n连接成功。。。");
            connection.close();
        }
        long stop = System.currentTimeMillis();
        System.out.println("连接用时：" + (stop - start));

    }
}
