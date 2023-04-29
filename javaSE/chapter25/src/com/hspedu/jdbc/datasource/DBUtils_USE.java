package com.hspedu.jdbc.datasource;

import com.hspedu.jdbc.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBUtils_USE {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select id,name,sex from actor";
        List<Actor> query = queryRunner.query(connection, sql, new BeanListHandler<Actor>(Actor.class));
        System.out.println(query);
        connection.close();
    }
}
