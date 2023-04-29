package com.hspedu.dao_.dao;

import com.hspedu.dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDAO<T> {
    private QueryRunner qr = new QueryRunner();

    //通用的dml方法，针对任意的表
    public int update(String sql, Object... parameters) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        try {
            return qr.update(connection,sql,parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,connection);
        }
    }

    //返回对应的ArrayList集合,多行
    public List<T> queryMulti(String sql, Class<T> c, Object... parameters) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        try {
            return qr.query(connection, sql, new BeanListHandler<T>(c), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,connection);
        }
    }

    //返回单行
    public T querySingle(String sql, Class<T> c, Object... parameters) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        try {
            return qr.query(connection, sql, new BeanHandler<T>(c), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,connection);
        }
    }

    //返回单行，单列
    public Object queryScalar(String sql, Object... parameters) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        try {
            return qr.query(connection, sql, new ScalarHandler<>(), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null,connection);
        }
    }
}
