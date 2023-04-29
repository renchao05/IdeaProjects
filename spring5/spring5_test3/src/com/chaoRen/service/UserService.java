package com.chaoRen.service;

import com.chaoRen.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Value(value = "任超")
    private String name;
//    @Autowired
//    @Qualifier(value = "ren")

    @Resource(name = "ren")
    public UserDao userDao;

    public void add() {
        userDao.add();
        System.out.println("add Service....." + name);
    }
}
