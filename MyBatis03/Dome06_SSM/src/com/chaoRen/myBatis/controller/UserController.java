package com.chaoRen.myBatis.controller;

import com.chaoRen.myBatis.bean.User;
import com.chaoRen.myBatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("users")
    public String userList(Map<String, Object> map) {
        List<User> users = userService.getUsers();
        System.out.println(users);
        map.put("users", users);
        return "user_list";
    }

    @RequestMapping("/addUser")
    public String addUser(User user) {
        System.out.println("用户信息：" + user);
        Integer integer = userService.addUser(user);
        System.out.println(integer > 0 ? "添加成功" : "添加失败");
        return "success";
    }
}
