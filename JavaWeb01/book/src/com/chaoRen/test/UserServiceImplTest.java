package com.chaoRen.test;

import com.chaoRen.pojo.User;
import com.chaoRen.service.UserService;
import com.chaoRen.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private final UserService userService = new UserServiceImpl();

    @Test
    void registerUser() {
        int r = userService.registerUser(new User(null, "renchao2", "333", "ren@163.com"));
        System.out.println(r == -1 ? "注册失败" : "注册成功");
    }

    @Test
    void login() {
        User r = userService.login(new User(null, "renchao2", "3323", "ren@163.com"));
        System.out.println(r == null ? "登陆失败" : "登陆成功");
    }

    @Test
    void existsUsername() {
        boolean r = userService.existsUsername("renchao2");
        System.out.println(r ? "用户已存在" : "用户名可用");
    }
}