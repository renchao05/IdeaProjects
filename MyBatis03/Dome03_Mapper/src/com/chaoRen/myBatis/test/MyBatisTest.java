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
import java.util.HashMap;
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
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(11);
            System.out.println(user);
        }
    }

    @Test
    public void getUserByIdAndName() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSession();
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserByIdAndName(11,"任超");
            System.out.println(user);
        }
    }

    @Test
    public void getUserByMap() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSession();
        Map<String, Object> map = new HashMap<>();
        map.put("id", 11);
        map.put("userName", "任超");
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserByMap(map);
            System.out.println(user);
        }
    }

    @Test
    public void deleteUserById() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSession();
        try (SqlSession sqlSession = sessionFactory.openSession(true)) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int i = mapper.deleteUserById(30);
            System.out.println(i > 0 ? "删除成功" : "删除失败");
        }
    }

    @Test
    public void getAllUser() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSession();
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            for (User user : mapper.getAllUser()) {
                System.out.println(user);
            }
        }
    }

    @Test
    public void getAllUserMap() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSession();
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<Integer, User> userMap = mapper.getAllUserMap();
            System.out.println(userMap);
        }
    }

    @Test
    public void addUser() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSession();
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(null, "chaoRen", "222", "chao@qq.com");
            int i = mapper.addUser(user);
            sqlSession.commit();
            System.out.println(user);
            System.out.println(i > 0 ? "添加成功" : "添加失败");
        }
    }

    @Test
    public void updateUser() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSession();
        SqlSession sqlSession = sessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(9, "任超FFF", "222", "RC@qq.com");
        int i = mapper.updateUser(user);
        sqlSession.commit();
        System.out.println(i > 0 ? "修改成功" : "修改失败");
    }
}
