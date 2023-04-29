package com.renChao.servlet;

import com.google.gson.Gson;
import com.renChao.pojo.Person;
import com.renChao.pojo.Wife;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class AjaxServlet extends BaseServlet {

    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Ajax进来了。。。");
        Person person = new Person(1, "任超", new Wife(2, "王道月"));
        Gson gson = new Gson();
        String ps = gson.toJson(person);
        resp.getWriter().write(ps);
    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryAjax进来了。。。");
        Person person = new Person(1, "任超", new Wife(2, "王道月"));
        Gson gson = new Gson();
        String ps = gson.toJson(person);
        resp.getWriter().write(ps);
    }

    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryGet。。。");
        Person person = new Person(1, "任超", new Wife(2, "王道月"));
        Gson gson = new Gson();
        String ps = gson.toJson(person);
        resp.getWriter().write(ps);
    }

    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQueryPost。。。");
        Person person = new Person(1, "任超", new Wife(2, "王道月"));
        Gson gson = new Gson();
        String ps = gson.toJson(person);
        resp.getWriter().write(ps);
    }

    protected void getJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getJSON。。。");
        Person person = new Person(1, "任超", new Wife(2, "王道月"));
        Gson gson = new Gson();
        String ps = gson.toJson(person);
        resp.getWriter().write(ps);
    }

    protected void serialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("serialize。。。");
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
        System.out.println(req.getParameter("single"));
        System.out.println(req.getParameter("multiple"));
        Person person = new Person(1, "任超", new Wife(2, "王道月"));
        Gson gson = new Gson();
        String ps = gson.toJson(person);
        resp.getWriter().write(ps);
    }


}
