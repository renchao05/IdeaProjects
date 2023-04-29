package com.chaoren.admin;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@DisplayName("这个是测试类！")
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;


    @DisplayName("这个是测试方法，测试1")
    @Test
    void test01() {
        System.out.println("测试1。。");
    }

    @Test
    void test02() {
        System.out.println("测试2。。");
    }

    @AfterEach
    void after() {
        System.out.println("方法之前执行===");
    }

    @BeforeEach
    void beforeAll() {
        System.out.println("方法之后执行===");
    }

//    @Test
//    void contextLoads() {
//        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
//        System.out.println("====================================");
//        System.out.println("查询到的数量是：" + aLong);
//        System.out.println(dataSource.getClass());
//    }

}
