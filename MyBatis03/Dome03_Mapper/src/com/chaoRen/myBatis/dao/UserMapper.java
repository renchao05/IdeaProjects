package com.chaoRen.myBatis.dao;

import com.chaoRen.myBatis.bean.User;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User getUserById(Integer id);
    List<User> getAllUser();
    //告诉MyBatis封装的时候那个属性作为Map的Key值
    @MapKey("id")
    Map<Integer, User> getAllUserMap();
    int addUser(User user);
    int updateUser(User user);
    int deleteUserById(Integer id);
    User getUserByIdAndName(Integer id,String name);
    User getUserByMap(Map<String,Object> map);
}
