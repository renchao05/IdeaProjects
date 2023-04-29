package com.chaoRen.test;

import com.chaoRen.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;

public class JDBCUtilsTest {


    @Test
    public void testJDBCUtils() {
//        for (int i = 0; i < 100; i++) {
//            Connection connection = JDBCUtils.getConnection();
//            System.out.println(connection);
//            JDBCUtils.close(null, connection);
//        }
    }

    @Test
    public void testS() {
        Class<JDBCUtils> jdbcClass = JDBCUtils.class;
        ClassLoader classLoader = jdbcClass.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("druid.properties");
    }
}
