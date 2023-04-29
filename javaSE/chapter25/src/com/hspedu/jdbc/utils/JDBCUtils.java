package com.hspedu.jdbc.utils;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String driver;
    private static String url;
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("src\\mysql.properties"));
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //连接数据库，返回Connection
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //关闭相关资源
    public static void close(ResultSet set, Statement statement, Connection connection) {
        try {
            if (set != null)
                set.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
