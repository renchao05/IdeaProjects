package com.renchao.fund.mvc.controller;

import com.renchao.fund.entity.Admin;
import com.renchao.fund.service.AdminService;
import com.renchao.fund.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/test")
    public String doTest(ModelMap modelMap,HttpServletRequest req) {
        List<Admin> adminList = adminService.getAll();
        modelMap.addAttribute("adminList", adminList);

        System.out.println(req.getRequestURI());
        System.out.println(req.getParameter("Referer"));
        System.out.println(req.getHeader("Accept"));
        return "test";
    }


    @RequestMapping("/test_axios")
    public String testAxios() {
        return "test_axios";
    }

    @RequestMapping("/test_ajax")
    public String testAjax() {
        System.out.println(4/0);
        return "test_ajax";
    }

    @RequestMapping("/testJSON")
    @ResponseBody
    public ResultEntity<Admin> testJSON(@RequestBody Admin admin,HttpServletRequest request) {
        String acceptHeader = request.getHeader("Accept");
        String xRequestHeader = request.getHeader("X-Requested-With");
        System.out.println(acceptHeader);
        System.out.println(xRequestHeader);
        System.out.println(admin);
        return ResultEntity.successWithData(admin);
    }

    @RequestMapping("/testAjax")
    @ResponseBody
    public ResultEntity<Admin> testAjax(@RequestBody String str) {
        Admin admin = null;
        admin.getEmail();
        System.out.println(str);
        return ResultEntity.successWithoutData();
    }
}
