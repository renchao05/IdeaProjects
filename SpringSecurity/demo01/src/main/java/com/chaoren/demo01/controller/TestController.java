package com.chaoren.demo01.controller;

import com.chaoren.demo01.bean.Users;
import com.chaoren.demo01.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UsersMapper usersMapper;

    @PostMapping("/add")
    public String add(Users users) {
        usersMapper.insert(users);
        return "添加成功~";
    }


    @RequestMapping("/hello")
    public String hello() {
        return "hello Security";
    }

    @RequestMapping("/index")
    public String index() {
        return "hello Index!!";
    }

    @RequestMapping("/cc")
    public String cc() {
        return "hello CC!!";
    }


    @RequestMapping("/01")
    public String test01() {
        return "hello 01!!";
    }

    @RequestMapping("/success")
    public String success() {
        return "hello success!!";
    }


    @RequestMapping("/fail")
    public String fail() {
        return "hello fail!!";
    }


    @RequestMapping("/02")
    public String test02() {
        return "hello menu:system!!";
    }


    @RequestMapping("/testSecured")
    @Secured("ROLE_管理员")
    public String testSecured() {
        System.out.println("进入到方法了！！");
        return "hello testSecured!!";
    }

    @RequestMapping("/testPreAuthorize")
    @PreAuthorize("hasRole('管理员')")
    public String testPreAuthorize() {
        System.out.println("进入到方法了！！");
        return "hello testPreAuthorize!!";
    }


    @RequestMapping("/testPostAuthorize")
    @PostAuthorize("hasRole('管理员')")
    public String testPostAuthorize() {
        System.out.println("进入到方法了！！");
        return "hello testPostAuthorize!!";
    }

    @RequestMapping("getAll")
    @PreAuthorize("hasRole('ROLE_管理员')")
    @PostFilter("filterObject.username == 'admin1'")
    public List<Users> getAllUser(){
        ArrayList<Users> list = new ArrayList<>();
        list.add(new Users(1,"admin1","6666"));
        list.add(new Users(2,"admin2","888"));
        return list;
    }


    @RequestMapping("/getTestPreFilter")
    @PreAuthorize("hasRole('ROLE_管理员')")
    @PreFilter(value = "filterObject.id%2==0")
    public List<Users> getTestPreFilter(@RequestBody List<Users> list){
        list.forEach(t-> {
            System.out.println(t.getId()+"\t"+t.getUsername());
        });
        return list;
    }


}
