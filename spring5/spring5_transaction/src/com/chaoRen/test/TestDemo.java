package com.chaoRen.test;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.chaoRen.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;


public class TestDemo {

    @Test
    public void testJDBC() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void TestTra() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.transferAccounts("任超","王道月",200.0);
    }

}
