package com.chaoRen.Demo;

import com.chaoRen.collectiontype.Book;
import com.chaoRen.collectiontype.Order;
import com.chaoRen.collectiontype.Student;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TestDemo {

    @Test
    public void TestBean1() {
        BeanFactory context = new ClassPathXmlApplicationContext("bean1.xml");
        Student student = context.getBean("student", Student.class);
        student.show();
    }

    @Test
    public void TestBean2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println("第四步，获取对象");
        System.out.println(book);
        context.close();
    }

    @Test
    public void TestBean3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Book book = context.getBean("myBean", Book.class);
        book.show();
    }

    @Test
    public void TestBean21() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book1 = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);
        System.out.println(book1);
        System.out.println(book2);
    }

    @Test
    public void TestBean31() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Book book1 = context.getBean("myBean", Book.class);
        Book book2 = context.getBean("myBean", Book.class);
        System.out.println(book1);
        System.out.println(book2);
    }

    @Test
    public void TestBean4() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println("第四步，获取对象");
        System.out.println(order);
        context.close();
    }

    @Test
    public void TestBean5() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

}
