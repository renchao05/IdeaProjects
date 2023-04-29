package com.chaoRen.test;

import com.chaoRen.dao.UserDao;
import com.chaoRen.dao.impl.UserDaoImpl;
import com.chaoRen.pojo.User;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    void queryUserByUsername() throws SQLException {
        User admin = userDao.queryUserByUsername("admin2");
        if (admin == null) {
            System.out.println("用户名可以使用。");
        } else {
            System.out.println("用户名已存在。");
        }

    }

    @Test
    void queryUserByUsernameAndPassword() {
        User user = userDao.queryUserByUsernameAndPassword("1admin", "admin");
        if (user == null) {
            System.out.println("用户名或密码错误！！！！！");
        } else {
            System.out.println("用户名和密码正确");
        }
    }

    @Test
    void saveUser() {
        int renchao = userDao.saveUser(new User(null, "renchao", "111111", "22@qq.com"));
        System.out.println(renchao);
        if (renchao == -1) {
            System.out.println("保存失败！！");
        } else {
            System.out.println("成功");
        }
    }
}