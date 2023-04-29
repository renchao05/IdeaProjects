package com.renchao.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("在柜台2打印：" + req.getParameter("name"));
        System.out.println("柜台1的章：" + req.getAttribute("key1"));
        System.out.println("Servlet2处理自己的业务");
    }
}
