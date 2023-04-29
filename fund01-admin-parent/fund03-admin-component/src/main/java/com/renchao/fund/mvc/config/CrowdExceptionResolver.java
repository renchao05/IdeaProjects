package com.renchao.fund.mvc.config;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renchao.fund.exception.LoginAcctAlreadyInUseException;
import com.renchao.fund.exception.LoginFailedException;
import com.renchao.fund.exception.NoPermissionException;
import com.renchao.fund.util.CrowdConstant;
import com.renchao.fund.util.CrowdUtil;
import com.renchao.fund.util.ResultEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

// @ControllerAdvice表示当前类是一个基于注解的异常处理器类
@ControllerAdvice
public class CrowdExceptionResolver {
    /**
     * 无访问权限异常
     */
    @ExceptionHandler(NoPermissionException.class)
    public ModelAndView noPermissionException(Exception exception,
                                              HttpServletRequest request,
                                              HttpServletResponse response) throws IOException {
        String viewName = "error/system-error";
        return commonResolve(viewName, exception, request, response);
    }

    /**
     * 登陆失败异常
     */
    @ExceptionHandler(LoginFailedException.class)
    public ModelAndView loginFailedException(Exception exception,
                                             HttpServletRequest request,
                                             HttpServletResponse response) throws IOException {
        String viewName = "admin/login";
        return commonResolve(viewName, exception, request, response);
    }

    /**
     * 用户名重复异常
     */
    @ExceptionHandler(LoginAcctAlreadyInUseException.class)
    public ModelAndView LoginAcctAlreadyInUseException(Exception exception,
                                             HttpServletRequest request,
                                             HttpServletResponse response) throws IOException {
        //根据请求头Referer，判断是添加还是更新，设置不同的View
        String viewName;
        if (request.getHeader("Referer").contains(CrowdConstant.ATTR_NAME_ADD_USER)) {
            viewName = "admin/add";
        } else {
            viewName = "admin/edit";
        }
        return commonResolve(viewName, exception, request, response);
    }


    /**
     * 核心异常处理方法
     */
    private ModelAndView commonResolve(String viewName, Exception exception,
                                       HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 1.判断当前请求类型
        boolean judgeResult = CrowdUtil.judgeRequestType(request);
        // 2.如果是Ajax请求
        if (judgeResult) {
            // 3.创建ResultEntity对象
            ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage());
            // 4.创建Gson对象
            Gson gson = new Gson();
            // 5.将ResultEntity对象转换为JSON字符串
            String json = gson.toJson(resultEntity);
            // 6.将JSON字符串作为响应体返回给浏览器
            response.getWriter().write(json);
            // 7.由于上面已经通过原生的response对象返回了响应，所以不提供ModelAndView对象
            return null;
        }

        // 8.如果不是Ajax请求则创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        // 9.将Exception对象存入模型
        modelAndView.addObject(CrowdConstant.ATTR_NAME_EXCEPTION, exception);
        // 10.设置对应的视图名称
        modelAndView.setViewName(viewName);
        // 11.将出现的异常信息在请求域中进行共享
        request.setAttribute("ex",exception);
        // 12.返回modelAndView对象
        return modelAndView;
    }

}

