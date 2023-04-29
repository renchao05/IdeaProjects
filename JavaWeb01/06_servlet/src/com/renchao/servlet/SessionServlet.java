package com.renchao.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.getWriter().write("Session已经销毁。");
    }

    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("Session存储成功。");
    }

    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object key1 = session.getAttribute("key1");
        resp.getWriter().write("Session的Key1的值：" + key1 + "<br>");

        resp.getWriter().write("Session的默认超时时长：" + session.getMaxInactiveInterval());
    }

    protected void createSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("Session创建成功。");
        resp.getWriter().write("SessionId:" + session.getId() + "<br>");
        resp.getWriter().write("是否是新的：" + (session.isNew() ? "新的" : "旧的"));
    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        // 先获取 Session 对象
        HttpSession session = req.getSession();
        // 设置当前 Session3 秒后超时
        session.setMaxInactiveInterval(3);
        resp.getWriter().write("当前 Session 已经设置为 3 秒后超时");
    }
}
