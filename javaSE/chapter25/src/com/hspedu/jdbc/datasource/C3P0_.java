package com.hspedu.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3P0_ {
    public static void main(String[] args) throws SQLException {
        ComboPooledDataSource ren_chao = new ComboPooledDataSource("ren_chao");

        System.out.println("开始连接。。。");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            Connection connection = ren_chao.getConnection();
//            System.out.println(connection.getClass() + "\n连接成功。。。");
            connection.close();
        }
        long stop = System.currentTimeMillis();
        System.out.println("连接用时：" + (stop - start));
    }
}
