package com.renchao.servlet;

import com.renchao.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("key3600", "value3600");
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        if (cookie != null) {
            cookie.setMaxAge(5);
            resp.addCookie(cookie);
        }
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("key2", "newValue");
        resp.addCookie(cookie);

        Cookie cookie1 = CookieUtils.findCookie("key1", req.getCookies());
        if (cookie1 != null) {
            cookie1.setValue("newValue1");
            resp.addCookie(cookie1);
        }
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            resp.getWriter().write(cookie.getName()+ "=" + cookie.getValue() + "<br>");
        }

        Cookie iWantCookie = CookieUtils.findCookie("key2",cookies);
        if (iWantCookie != null) {
            resp.getWriter().write( "单独获取的：" + iWantCookie.getName() + "=" + iWantCookie.getValue());
        }
    }


    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("key1", "value1");
        resp.addCookie(cookie);
        Cookie cookie2 = new Cookie("key2", "value2");
        resp.addCookie(cookie2);
        Cookie cookie3 = new Cookie("key3", "value3");
        resp.addCookie(cookie3);

        resp.getWriter().write("Cookie创建成功");
    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        Cookie cookie = new Cookie("path1", "path1");
        // getContextPath() ===>>>> 得到工程路径
        cookie.setPath( req.getContextPath() + "/abc" ); // ===>>>> /工程路径/abc
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有 Path 路径的 Cookie\n" + req.getContextPath());
    }

    protected void testSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

        Cookie cookie = CookieUtils.findCookie("JSESSIONID", req.getCookies());

        cookie.setMaxAge(1800);

        resp.addCookie(cookie);

        resp.getWriter().write("修改了 JSESSIONID 超时时长" + req.getContextPath());
    }
}
