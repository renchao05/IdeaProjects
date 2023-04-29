package com.renchao.Thymeleaf;

import com.renchao.bean.Employee;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/TestServlet")
public class TestServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1.创建ArrayList对象并填充
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1, "tom", 500.00));
        employeeList.add(new Employee(2, "jerry", 600.00));
        employeeList.add(new Employee(3, "harry", 700.00));

        // 2.将集合数据存入请求域
        req.setAttribute("employeeList", employeeList);


        req.setAttribute("memberLevel", "level-3");



        // 2.调用父类方法解析视图
        super.processTemplate("target", req, resp);
    }
}
