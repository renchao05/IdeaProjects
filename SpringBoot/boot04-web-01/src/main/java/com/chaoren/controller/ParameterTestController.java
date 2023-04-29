package com.chaoren.controller;

import com.chaoren.bean.Person;
import com.chaoren.bean.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{name}")
    public String getCar(@PathVariable Integer id,
                         @PathVariable String name,
                         @PathVariable Map<String, String> pv) {
        System.out.println("id:" + id);
        System.out.println("name:" + name);
        System.out.println("pv:" + pv);
        return "请求成功！！！";
    }

    @GetMapping("/car")
    public String testRequestHeader(@RequestHeader("Host") String host,
                                    @RequestHeader Map<String, String> header) {
        System.out.println("Host:" + host);
        System.out.println("RequestHeader:" + header);
        return "请求成功！！！";
    }

    @GetMapping("/requestParam")
    public String testRequestParam(@RequestParam("username") String name,
                                   @RequestParam("password") String pwd,
                                   @RequestParam Map<String, String> params) {
        System.out.println("username:" + name);
        System.out.println("password:" + pwd);
        System.out.println("params:" + params);
        return "请求成功！！！";
    }

    @GetMapping("/savePerson")
    public Person savePerson(Person person) {
        return person;
    }


    @GetMapping("/model")
    public String testModelAttribute(@ModelAttribute User user) {
        System.out.println(user);
        return "请求成功！！！";
    }

    @GetMapping("/cookie")
    public String testCookie(@CookieValue("Idea-b88688e3") String idea,
                             @CookieValue("Idea-b88688e3") Cookie cookie) {
        System.out.println(idea);
        System.out.println(cookie);
        return "请求成功！！！";
    }

    @GetMapping("/cars/{path}")
    public Map<String, Object> carsSell(@MatrixVariable("low") Integer low,
                                        @MatrixVariable("brand") List<String> brand,
                                        @PathVariable("path") String path) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    @GetMapping("/boss/{bossId}/{empId}")
    public Map<String, Object> boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                                    @MatrixVariable(value = "age", pathVar = "empId") Integer empAge) {
        Map<String, Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        return map;
    }

    @PostMapping("/save")
    public Map<String, Object> postMethod(@RequestBody String body) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("body", body);
        return map;
    }

/** ==输出结果===========================
 * User(username=任超, password=12345, age=32)
 */
}
