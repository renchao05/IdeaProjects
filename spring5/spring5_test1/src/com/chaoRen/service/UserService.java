package com.chaoRen.service;

import com.chaoRen.dao.UserDao;

public class UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void add() {
        System.out.println("添加成功。。。。");
        userDao.update();
    }
}
