package com.chaoRen.service.impl;

import com.chaoRen.dao.UserDao;
import com.chaoRen.dao.impl.UserDaoImpl;
import com.chaoRen.pojo.User;
import com.chaoRen.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public int registerUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        return userDao.queryUserByUsername(username) != null;
    }
}
