package com.chaoRen.spring5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void updateMoney(String name,double m) {
        String sql = "update t_assets set money = money+? where username=?";
        jdbcTemplate.update(sql, m,name);
    }
}
