package com.hspedu.jdbc.resultset_;

import com.hspedu.jdbc.GetConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSet_ {
    public static void main(String[] args) throws SQLException {
        Connection connection = GetConn.get();
        Statement statement = connection.createStatement();
        String sql = "select id,content from news";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String content = resultSet.getString(2);
            System.out.println(id + "\t" + content);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
