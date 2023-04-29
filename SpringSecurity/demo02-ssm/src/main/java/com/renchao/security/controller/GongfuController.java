package com.renchao.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GongfuController {


    @Secured("ROLE_ADMIN")
    @GetMapping("/level1/{path}")
    public String leve1Page(@PathVariable("path") String path) {
        return "/level1/" + path;
    }

    @GetMapping("/level2/{path}")
    public String leve2Page(@PathVariable("path") String path) {
        return "/level2/" + path;
    }

    @GetMapping("/level3/{path}")
    public String leve3Page(@PathVariable("path") String path) {
        return "/level3/" + path;
    }

}
