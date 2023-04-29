package com.chaoRen.myBatis.test;

import com.chaoRen.myBatis.bean.User;
import com.chaoRen.myBatis.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {

    public SqlSessionFactory getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 老版本方法
     */
    @Test
    public void test() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSession();

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            User user = sqlSession.selectOne("com.chaoRen.myBatis.selectUser", 5);
            System.out.println(user);
        }
    }

    /**
     * 新方法，采用接口
     */
    @Test
    public void test01() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSession();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(userMapper.getClass());
            User user = userMapper.getUserById(5);
            System.out.println(user);
        }
    }
}
