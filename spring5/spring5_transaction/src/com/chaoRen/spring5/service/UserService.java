package com.chaoRen.spring5.service;

import com.chaoRen.spring5.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public void transferAccounts(String out, String in, Double m) {
        userDao.updateMoney(out, -m);
//        int i = 7/0;
        userDao.updateMoney(in,m);
    }
}
