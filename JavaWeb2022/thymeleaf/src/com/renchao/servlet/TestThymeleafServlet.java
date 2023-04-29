package com.renchao.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet("/index")
public class TestThymeleafServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("初始化成功");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.声明当前请求要前往的视图名称
        String viewName = "index";

        // 2.调用ViewBaseServlet父类中的解析视图模板的方法
//        super.processTemplate(viewName, req, resp);
    }
}
