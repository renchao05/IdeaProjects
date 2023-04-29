package com.chaoRen.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private final static DataSource dataSource;
    private final static ThreadLocal<Connection> conn = new ThreadLocal<>();
    static {
        Properties properties = new Properties();
        try {
//            //必须要使用反射
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
//            properties.load(new FileInputStream("src\\druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //连接数据库，返回Connection
    public static Connection getConnection() {
        try {
            Connection connection = conn.get();
            if (connection == null) {
                connection = dataSource.getConnection();
                conn.set(connection);
                connection.setAutoCommit(true);
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 提交实物和关闭连接
     */
    public static void commitAndClose() {
        Connection connection = conn.get();
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn.remove();
            }
        }
    }

    /**
     * 回滚和关闭连接
     */
    public static void rollbackAndClose() {
        Connection connection = conn.get();
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                    conn.remove();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *
     * @param set
     * @param connection

    public static void close(ResultSet set, Connection connection) {
        try {
            if (set != null)
                set.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
     */
}
