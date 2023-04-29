package com.renChao.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet3 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("hello3  初始化成功。。。。");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、getRequestURI() 获取请求的资源路径，如 /servlet/hello3
        System.out.println("URI => " + req.getRequestURI());

        // 2、getRequestURL() 获取请求的统一资源定位符（绝对路径）
        //      如 http://127.0.0.1:8080/servlet/hello3
        System.out.println("URL => " + req.getRequestURL());

        // 3、getRemoteHost() 获取客户端的 ip 地址
        System.out.println("客户端 ip 地址 => " + req.getRemoteHost());

        // 4、getHeader() 获取请求头
        System.out.println("请求头 User-Agent ==>> " + req.getHeader("User-Agent"));

        // 5、getMethod() 获取请求的方式 GET 或 POST
        System.out.println( "请求的方式 ==>> " + req.getMethod() );
    }
}
