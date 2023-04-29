package com.renchao.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Hello3 extends BaseServlet {

    protected void temp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String code =(String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        if (code.equals(req.getParameter("code"))) {
            if (username.equals("renchao")) {
                System.out.println("登陆成功");
                req.getSession().setAttribute("username",username);
                resp.sendRedirect("b.html");
            } else {
                System.out.println("登陆失败");
            }
        } else {
            System.out.println("验证码输入错误。");
        }
    }
}
