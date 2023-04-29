package com.chaoRen.myBatis.dao;

import com.chaoRen.myBatis.bean.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User getUserById(Integer id);

    List<User> getUserByName(@Param("name") String name);

    Integer addUser(User user);

    List<User> getUserByIdAndName(@Param("id")Integer id,@Param("name")String name);

    Integer updateUser(User user);

    List<User> getUserInId(List<Integer> lists);
    List<User> getUserInArr(Integer[] arr);
}
