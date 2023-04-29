package com.chaoren.admin.controller;

import com.chaoren.admin.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 登陆页面
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {

        return "login";
    }

    @PostMapping("/login")
    public String admin(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUsername()) && "12345".equals(user.getPassword())) {
            session.setAttribute("loginUser", user);
            return "redirect:/admin.html";
        }
        model.addAttribute("msg", "账号或者密码错误！");
        return "login";
    }

    /**
     * 去admin页面
     * 登陆成功，重定向到本页面，防止表单重复提交
     */
    @GetMapping("/admin.html")
    public String adminPage(HttpSession session,Model model) {
        Object user = session.getAttribute("loginUser");
        if (user != null) {
            return "admin";
        }
        model.addAttribute("msg", "请先登陆！");
        return "login";
    }

    @ResponseBody
    @RequestMapping("/sql")
    public Integer testSQL() {
        return jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
    }
}
