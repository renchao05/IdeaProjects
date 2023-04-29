package com.renchao.fund.mvc.controller;

import com.github.pagehelper.PageInfo;
import com.renchao.fund.entity.Admin;
import com.renchao.fund.exception.LoginAcctAlreadyInUseException;
import com.renchao.fund.service.AdminService;
import com.renchao.fund.util.CrowdConstant;
import com.renchao.fund.util.CrowdUtil;
import com.renchao.fund.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 删除管理员
     */
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id, HttpServletRequest req) {

        adminService.deleteAdmin(id);
        //通过 Referer 获取原来的页面，然后重定向到原来页面
        return "redirect:" + req.getHeader("Referer");
    }

    /**
     * 更新信息控制器方法
     */
    @PutMapping("/user")
    public String updateUser(HttpServletRequest req, Admin admin, RedirectAttributes attr) {
        req.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN, admin);

        adminService.updateAdmin(admin);

        //设置重定向请求参数，查询关键词，这样可以看到修改后的用户信息
        attr.addAttribute("keyword", admin.getLoginAcct());
        return "redirect:/admin/user";
    }

    /**
     * 去更新管理员表单页面
     */
    @GetMapping("/user/{id}")
    public String toEdit(@PathVariable("id") Integer id,ModelMap modelMap) {
        Admin admin = adminService.getAdminById(id);
        //将信息存入 request 用于回显
        modelMap.addAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN, admin);
        return "admin/edit";
    }

    /**
     * 添加 管理员
     */
    @PostMapping("/user")
    @PreAuthorize("hasAuthority('user:add')")
    public String addUser(Admin admin) {
        adminService.saveAdmin(admin);
        // 重定向到分页页面，使用重定向是为了避免刷新浏览器重复提交表单
        return "redirect:/admin/user?pageNum=" + Integer.MAX_VALUE;
    }


    /**
     *查询管理员
     */
    @GetMapping("/user")
    public String getUser(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                          ModelMap modelMap) {
        PageInfo<Admin> pageInfo = adminService.getUserPage(keyword, pageNum, pageSize);
        modelMap.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO, pageInfo);
        return "admin/user";
    }

    /**
     * 登录
     */
    @RequestMapping("/do/login")
    public String doLogin(@RequestParam("loginAcct") String loginAcct,
                          @RequestParam("userPswd") String userPswd,
                          HttpSession session) {
        // 查询用户，如果没有查询到会直接抛异常
        Admin admin = adminService.getAdminByLoginAcct(loginAcct, userPswd);

        // 把用户信息存入 session 域
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN, admin);

        // 为了避免刷新浏览器导致重复提交登录表单，重定向到目标页面。
        return "redirect:/admin/to/main/page";
    }

    /**
     * 退出登录
     */
    @RequestMapping("/do/logout")
    public String doLogout(HttpSession session) {
        // 让 session 立即失效
        session.invalidate();
        //重定向到登录页面
        return "redirect:/admin/do/login/page";
    }
}
