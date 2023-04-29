package com.hspedu.mhl.dao;


import com.hspedu.mhl.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDAO<T> {
    private QueryRunner qr = new QueryRunner();

    /**
     * 通用的dml方法，针对任意的表
     * @param sql sql语句
     * @param parameters 可变形参
     * @return 返回受影响的行数
     */
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

    /**
     * 返回对应的ArrayList集合,多行
     * @param sql sql语句
     * @param c Class对象
     * @param parameters 可变形参
     * @return 返回查询到的List
     */
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

    /**
     * 返回单行
     * @param sql sql语句
     * @param c Class对象
     * @param parameters 可变形参
     * @return 返回单个对象
     */
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

    /**
     * 返回单行，单列
     * @param sql sql语句
     * @param parameters 可变形参
     * @return 返回Object对象
     */
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
