package com.chaoRen.web;

import com.chaoRen.pojo.User;
import com.chaoRen.service.UserService;
import com.chaoRen.service.impl.UserServiceImpl;
import com.chaoRen.utils.JDBCUtils;
import com.chaoRen.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null) {
//            System.out.println("登陆失败！！！");
            req.setAttribute("msg", "用户名或密码错误！");
            req.setAttribute("username", username);
            req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
        } else {
//            System.out.println("登陆成功");
            req.getSession().setAttribute("user", loginUser);
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req, resp);
        }
    }

    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String mail = req.getParameter("email");
        String code = req.getParameter("code");
        String keyCode = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        req.setAttribute("username", username);
        req.setAttribute("password", password);
        req.setAttribute("email", mail);

        if (code.equalsIgnoreCase(keyCode)) {
            if (userService.existsUsername(username)) {
//                System.out.println("用户已存在");
                req.setAttribute("msg", "用户已存在!");
                req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
            } else {
                userService.registerUser(new User(null, username, password, mail));
                req.getRequestDispatcher("pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
//            System.out.println("验证码输入错误");
            req.setAttribute("msg", "验证码输入错误!");
            req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
        }
    }


    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean existsUsername = userService.existsUsername(username);
        HashMap<String, Boolean> map = new HashMap<>();
        map.put("existsUsername", existsUsername);
        Gson gson = new Gson();
        String json = gson.toJson(map, HashMap.class);
        resp.getWriter().write(json);
    }
}
