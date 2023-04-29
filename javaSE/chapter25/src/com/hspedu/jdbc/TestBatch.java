package com.hspedu.jdbc;

import com.hspedu.jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestBatch {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into t_book values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        long l1 = System.currentTimeMillis();
        System.out.println("开始往数据库存储。。。。。");
        for (int i = 0; i < 50000; i++) {
            preparedStatement.setString(1,"" + i);
            preparedStatement.setString(2,"红楼梦" + i);
            preparedStatement.setString(3,"待上架");
            preparedStatement.addBatch();
            if ((i + 1) % 10000 == 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }
        long l2 = System.currentTimeMillis();
        System.out.println("用时：" + (l2-l1));
    }
}
