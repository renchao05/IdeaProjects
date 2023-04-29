package com.chaoRen.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "ren")
public class UserDaoImpl implements UserDao{

    @Override
    public void add() {
        System.out.println("UserDao  add.....");
    }
}
