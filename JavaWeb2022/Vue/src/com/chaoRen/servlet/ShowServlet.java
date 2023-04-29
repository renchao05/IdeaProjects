package com.chaoRen.servlet;

import com.chaoRen.pojo.Fruit;
import com.chaoRen.service.impl.FruitServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/showFruit")
public class ShowServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FruitServiceImpl fruitService = new FruitServiceImpl();
        List<Fruit> fruits = fruitService.queryFruits();
        Type userListType = new TypeToken<ArrayList<Fruit>>(){}.getType();
        Gson gson = new Gson();
        String json = gson.toJson(fruits, userListType);

        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(json);

    }
}
