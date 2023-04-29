package com.chaoRen.myBatis.dao;

import com.chaoRen.myBatis.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> getUsers();

    Integer addUser(User user);
}
