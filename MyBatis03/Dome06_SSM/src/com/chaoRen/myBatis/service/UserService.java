package com.chaoRen.myBatis.service;

import com.chaoRen.myBatis.bean.User;
import com.chaoRen.myBatis.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    public Integer addUser(User user) {
        Integer integer = userMapper.addUser(user);

        int s = 2/0;
        return integer;
    }
}
