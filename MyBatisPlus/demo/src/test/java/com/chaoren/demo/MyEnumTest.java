package com.chaoren.demo;

import com.chaoren.demo.bean.User;
import com.chaoren.demo.enums.SexEnum;
import com.chaoren.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyEnumTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test01() {
        User user = new User(null, "王道月", 32, SexEnum.FEMALE, "666@qq.com", null);
        userMapper.insert(user);
    }
}
