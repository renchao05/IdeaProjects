package com.hspedu.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 第一个简单的Jdbc程序，完成简单的操作
 */

public class Jdbc01 {
    public static void main(String[] args) throws SQLException {
        //前置工作：在项目下创建一个文件夹，比如libs
        //将mysql*.jar包拷贝到该文件夹，然后右击add to project..加入到该项目
        //1.注册驱动
        Driver driver = new Driver();//创建Driver对象

        //2.得到连接
        String url = "jdbc:mysql://127.0.0.1:3306/rc_db01";
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","123");
        Connection connect = driver.connect(url, properties);

        //3.执行sql
        String sql = "insert into actor values(null,'刘亦菲','女','1985-05-06','13912345678')";
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "成功" : "失败");

        //4.关闭连接资源
        statement.close();
        connect.close();
    }
}
