package com.chaoren.admin.controller;

import com.chaoren.admin.bean.User;
import com.chaoren.admin.exception.UsersToManyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table() {

        int i = 7/0;

        return "/table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model) {
        List<User> users = Arrays.asList(new User("张三", "123456"),
                new User("lishi", "567890"),
                new User("wangwu", "pppppp"),
                new User("damin", "88899955"),
                new User("大名", "hh126"),
                new User("码字", "8888"));
        if (users.size() > 3) {
            throw new UsersToManyException();
        }
        model.addAttribute("users", users);
        return "/table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {

        return "/table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {


        return "/table/editable_table";
    }

}
