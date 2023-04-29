package com.chaoRen.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/testVue")
public class AxiosServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        System.out.println(username);
        System.out.println(userPwd);

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("服务器收到消息：" + username + "+" + userPwd);
    }
}
