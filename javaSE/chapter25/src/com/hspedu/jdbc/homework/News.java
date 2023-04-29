package com.hspedu.jdbc.homework;

import com.hspedu.jdbc.GetConn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class News {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Connection connection = GetConn.get();
        Statement statement = connection.createStatement();

        reds(statement);
//        int rows = statement.executeUpdate("update news set content = '我被修改了~~' where id = 1");
//        int rows = statement.executeUpdate("delete from news where id = 3");
//        System.out.println(rows > 0 ? "成功" : "失败");

        statement.close();
        connection.close();
    }

    public static void reds(Statement statement) throws SQLException {
        for (int i = 10; i < 11; i++) {
            int rows = statement.executeUpdate("insert into news values(null,'我是" + i + "号')");
            System.out.println(rows > 0 ? "成功" : "失败");
        }
    }
}
