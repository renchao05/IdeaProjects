package com.renChao.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet2 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Servlet 初始化。。。");
        System.out.println(config.getServletName());
        System.out.println(config.getInitParameter("user"));
        System.out.println(config.getInitParameter("password"));
        System.out.println(config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletConfig().getServletContext();

        //1、获取 web.xml 中配置的上下文参数 context-param
        System.out.println("context-param 参数 username 的值是:" + context.getInitParameter("username"));
        System.out.println("context-param 参数 password 的值是:" + context.getInitParameter("password"));

        //2、获取当前的工程路径，格式: /工程路径
        System.out.println("当前工程路径:" + context.getContextPath());

        //3、获取工程部署后在服务器硬盘上的绝对路径
        System.out.println("当前工程在服务器硬盘实际路径:" + context.getRealPath("/"));
        System.out.println("工程下 css 目录的绝对路径是:" + context.getRealPath("/css/"));
        System.out.println("工程下 img 目录 1.jpg 的绝对路径是:" + context.getRealPath("/img/1.jpg"));

        //4、像 Map 一样存取数据,整个工程都可以访问
        context.setAttribute("key","value");
    }
}
