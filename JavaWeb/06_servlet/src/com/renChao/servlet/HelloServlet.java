package com.renChao.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("Servlet 构造器执行。。。。");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Servlet 初始化。。。");
        System.out.println(servletConfig.getServletName());
        System.out.println(servletConfig.getInitParameter("user"));
        System.out.println(servletConfig.getInitParameter("password"));
        System.out.println(servletConfig.getServletContext());

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service 方法是专门用来处理请求和响应的
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet 被访问了。。");
        
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Servlet 销毁。。。。");
    }
}
