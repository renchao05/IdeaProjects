package com.hspedu.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcConn {

    //方式1
    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();//创建Driver对象
        String url = "jdbc:mysql://127.0.0.1:3306/rc_db01";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    //方式2
    @Test
    public void connect02() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();
        String url = "jdbc:mysql://127.0.0.1:3306/rc_db01";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123");
        Connection connect = driver.connect(url, properties);

        String sql = "insert into actor values(null,'刘亦菲','女','1985-05-06','13912255678')";
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "成功" : "失败");
    }

    //方式3，通过DriverManager统一管理
    @Test
    public void connect03() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();
        String url = "jdbc:mysql://127.0.0.1:3306/rc_db01";
        String user = "root";
        String password = "123";

        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "insert into actor values(null,'张柏芝','女','1984-06-08','13988888888')";
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "成功" : "失败");
    }

    //方式4，方式3的简化，使用Class.forName自动完成注册驱动，简化代码
    //这种方式是使用最多的
    @Test
    public void connect04() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/rc_db01";
        String user = "root";
        String password = "123";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    //方式5，方式4的基础上通过配置文件，让连接mysql更加灵活
    @Test
    public void connect05() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}
