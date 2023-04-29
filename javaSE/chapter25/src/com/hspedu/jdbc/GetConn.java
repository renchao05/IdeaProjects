package com.hspedu.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetConn {
    public static Connection get() throws SQLException {
        Properties properties = new Properties();
        String url = null;
        try {
            properties.load(new FileInputStream("src\\mysql.properties"));
            String driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(url, properties);
    }
}
