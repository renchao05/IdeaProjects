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
            List<User> users = mapper.getUserByIdAndName(null, null);
            System.out.println(users);
        }
    }

    @Test
    public void updateUser() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSession();
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Integer integer = mapper.updateUser(new User(19, null, "111", "xy11@sss.com"));
            sqlSession.commit();
            System.out.println(integer>0?"修改成功":"修改失败");
        }
    }

    @Test
    public void getUserInId() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSession();
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            ArrayList<Integer> lists = new ArrayList<>();
            lists.add(11);
            lists.add(5);
            lists.add(9);
            List<User> users = mapper.getUserInId(lists);
            System.out.println(users);
        }
    }

    @Test
    public void getUserInArr() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSession();
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Integer[] arr = {5, 9, 21};
            List<User> users = mapper.getUserInArr(arr);
            System.out.println(users);
        }
    }

    @Test
    public void addUser() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSession();
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            ArrayList<User> users = new ArrayList<>();
            users.add(new User(null, "任超A", "aa_aa", "aa@qq.com"));
            users.add(new User(null, "任超B", "bb_bb", "bb@qq.com"));
            users.add(new User(null, "任超C", "cc_cc", "cc@qq.com"));
            Integer integer = mapper.addUser(users);
            sqlSession.commit();
            System.out.println("添加的条数：" + integer);
        }
    }

    @Test
    public void getUserByName() throws IOException {
        SqlSessionFactory sessionFactory = getSqlSession();
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            String name = "王";
            List<User> users = mapper.getUserByName(name);
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

}
