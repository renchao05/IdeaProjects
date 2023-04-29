package com.chaoren.demo;

import com.chaoren.demo.bean.User;
import com.chaoren.demo.service.UserService;
import com.chaoren.demo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class MyServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetCount() {
        long count = userService.count();
        System.out.println("总记录数：" + count);
    }

    @Test
    public void testSaveBatch() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            users.add(new User(null, "任超" + i, 21 + i, i + "@qq.com",null));
        }
        boolean b = userService.saveBatch(users);
        System.out.println(b ? "保存成功。。" : "保存失败！！");
    }
}
