package com.renchao.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("在柜台1查看：" +req.getParameter("name"));
        req.setAttribute("key1", "Servlet1盖的章。。。");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("servlet2");
        requestDispatcher.forward(req,resp);
    }
}
