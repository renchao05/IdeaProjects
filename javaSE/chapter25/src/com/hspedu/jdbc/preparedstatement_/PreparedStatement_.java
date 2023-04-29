package com.hspedu.jdbc.preparedstatement_;

import com.hspedu.jdbc.GetConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatement_ {
    public static void main(String[] args) throws SQLException {
        Connection connection = GetConn.get();
        String sql = "delete from news where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        int i = preparedStatement.executeUpdate();
//        System.out.println(i > 0 ? "成功" : "失败");


        for (int i = 0; i < 11; i++) {
            preparedStatement.setInt(1,i);
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows > 0 ? "成功" : "失败");
        }

    }
}
