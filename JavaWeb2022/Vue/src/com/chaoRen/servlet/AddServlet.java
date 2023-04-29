package com.chaoRen.servlet;

import com.chaoRen.pojo.Fruit;
import com.chaoRen.service.impl.FruitServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/addFruit")
public class AddServlet extends HttpServlet {
    FruitServiceImpl fruitService = new FruitServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
        fruitService.addFruit(fruit);
    }
}
