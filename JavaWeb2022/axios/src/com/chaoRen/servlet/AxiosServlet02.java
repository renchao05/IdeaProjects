package com.chaoRen.servlet;

import com.chaoRen.bean.Fruit;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

@WebServlet("/testJSON")
public class AxiosServlet02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收Json
        req.setCharacterEncoding("UTF-8");
        BufferedReader reader = req.getReader();
        StringBuilder builder = new StringBuilder();
        String str;
        while ((str = reader.readLine()) != null) {
            builder.append(str);
        }
        reader.close();
        String requestBody = builder.toString();
        Gson gson = new Gson();
        Fruit fruit = gson.fromJson(requestBody, Fruit.class);
        System.out.println(fruit);

        //返回Json
        fruit = new Fruit(66, "香蕉", 5, 45, "新鲜的");
        String json = gson.toJson(fruit);
        //设置响应体的内容类型为json
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(json);
    }
}
