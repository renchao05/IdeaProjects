package com.renchao.fund.mvc.controller;

import com.renchao.fund.entity.Auth;
import com.renchao.fund.service.AuthService;
import com.renchao.fund.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping
    public ResultEntity<List<Auth>> getAllAuth() {
        List<Auth> auths = authService.getAllAuth();
        return ResultEntity.successWithData(auths);
    }

}
