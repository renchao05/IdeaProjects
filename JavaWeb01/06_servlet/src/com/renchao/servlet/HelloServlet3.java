package com.renchao.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class HelloServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello3 GET");
        ServletContext context = getServletContext();
        System.out.println(context.getAttribute("k1"));

        System.out.println("URI=====" + request.getRequestURI());
        System.out.println("URL()=====" + request.getRequestURL());
        System.out.println("Host()=====" + request.getRemoteHost());
        System.out.println("Accept-Language=====" + request.getHeader("Accept-Language"));
        System.out.println("getMethod()====="+request.getMethod());
        System.out.println(request.getAttribute("k3"));
        request.setAttribute("k3","我是测试的");
        System.out.println(request.getAttribute("k3"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello3 POST");
    }
}
