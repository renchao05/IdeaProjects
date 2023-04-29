package com.chaoren.admin.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(Ordered.HIGHEST_PRECEDENCE)  //设置最高优先级
@Controller
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {
        try {
            //由tomcat发送/error,调用BasicErrorController
            response.sendError(533,"我自定义的异常处理。。。");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView();  //也可以返回ModelAndView，按照正常流程渲染
    }
}
