package com.renchao.fund.mvc.controller;

import com.renchao.fund.exception.AccessForbiddenException;
import com.renchao.fund.exception.NoPermissionException;
import com.renchao.fund.util.CrowdConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

    @RequestMapping("/noPermission")
    public String noPermission() {
        throw new NoPermissionException(CrowdConstant.MESSAGE_NO_PERMISSION);
    }
}
