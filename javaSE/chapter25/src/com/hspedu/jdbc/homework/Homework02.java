package com.hspedu.jdbc.homework;

import com.hspedu.jdbc.GetConn;
import com.hspedu.jdbc.utils.JDBCUtilsByDruid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection connection = JDBCUtilsByDruid.getConnection();
//        String sql = "insert into admin values(?,?)";
//        String sql = "update admin set id = ? where id = ?";
        String sql = "select * from admin";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
//        JDBCUtilsByDruid.close(null,connection);
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String swd = resultSet.getString(2);
            System.out.println(id + "\t" + swd);
        }
        JDBCUtilsByDruid.close(resultSet,connection);
    }
}
