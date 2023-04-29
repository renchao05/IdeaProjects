package com.chaoRen.myBatis.test;

import com.chaoRen.myBatis.bean.User;
import com.chaoRen.myBatis.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    public SqlSessionFactory getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void getUserById() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSession();
        User user1,user2;
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            user1 = mapper.getUserById(11);
            System.out.println(user1);
        }
        try (SqlSession sqlSession2 = sessionFactory.openSession()) {
            UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
            user2 = mapper2.getUserById(11);
            System.out.println(user2);
        }
    }

}
