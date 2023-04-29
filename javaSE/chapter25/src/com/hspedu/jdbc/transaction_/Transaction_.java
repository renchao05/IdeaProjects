package com.hspedu.jdbc.transaction_;

import com.hspedu.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction_ {
    public static void main(String[] args) {
        PreparedStatement preparedStatement = null;
        Connection connection = JDBCUtils.getConnection();
        String sql1 = "update accou set balance = balance - 100 where id = 1";
        String sql2 = "update accou set balance = balance + 100 where id = 2";

        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();
//            int i = 3 / 0;
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,preparedStatement,connection);
        }
    }
}
