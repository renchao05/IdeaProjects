package com.chaoRen.spring5.testdemo;

import com.chaoRen.spring5.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestSpring5 {

    @Test
    public void testAdd() {
        //加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BeanFactory context2 = new ClassPathXmlApplicationContext("bean1.xml");
//        ApplicationContext context = new FileSystemXmlApplicationContext("bean1.xml");
        //获取配置创建的对象
        User user1 = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);

        System.out.println(user1 == user2);
//        user.show();
    }
}
