package com.chaoRen.test;

import com.chaoRen.spring5.config.SpringConfig;
import com.chaoRen.spring5.entity.Book;
import com.chaoRen.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class TestDemo {

    @Test
    public void test1() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book bookOne = bookService.findBookOne("1");
        System.out.println(bookService.name);
        System.out.println(bookOne);
    }

    @Test
    public void test2() throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.name);
    }

    @Test
    public void testJDBC() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testJdbcAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.add(new Book("1", "三国演义", "出售中"));
        bookService.add(new Book("2", "红楼梦", "售完"));
        bookService.add(new Book("3", "金瓶梅", "上架中"));
    }

    @Test
    public void testJdbcUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.updateBook(new Book("1", "红楼梦", "售完"));
    }

    @Test
    public void testJdbcDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.deleteBook("1");
    }

    @Test
    public void testJdbcQueryCount() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.findCount());
    }

    @Test
    public void testJdbcQueryBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.findBookOne("1"));
    }

    @Test
    public void testJdbcQueryAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        System.out.println(bookService.findAll());
    }

    @Test
    public void testJdbcBatchAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        ArrayList<Object[]> strings = new ArrayList<>();
        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
//            bookService.add(new Book("" + i,"红楼梦" + i,"待上架"));
            String[] str = {"" + i, "红楼梦" + i, "待上架"};
            strings.add(str);
        }
        System.out.println("开始往数据库存储。。。。。");
        bookService.batchAdd(strings);
        long l2 = System.currentTimeMillis();
        System.out.println("用时：" + (l2 - l1));
    }

    @Test
    public void testJdbcBatchUpdate() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        ArrayList<Object[]> strings = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            String[] str = {i * 111 + "红楼梦", "已上架", "" + i};
            strings.add(str);
        }
        bookService.batchUpdate(strings);
    }

    @Test
    public void testJdbcBatchDelete() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        ArrayList<Object[]> strings = new ArrayList<>();
        for (int i = 500; i < 20000; i++) {
            String[] str = {"" + i};
            strings.add(str);
        }
        bookService.batchDelete(strings);
    }

}


