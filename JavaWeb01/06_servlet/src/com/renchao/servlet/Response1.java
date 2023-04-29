package com.renchao.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问过这里");
//        resp.setStatus(302);
//        resp.setHeader("location","http://localhost:8080/06_servlet/Response2");
        resp.sendRedirect("http://localhost:8080/06_servlet/Response2");
    }
}
