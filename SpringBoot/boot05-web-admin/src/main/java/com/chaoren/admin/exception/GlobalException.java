package com.chaoren.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个Web Controller的异常
 */
//@Slf4j
@ControllerAdvice
public class GlobalException {
    //定义处理数学运行异常和空指针异常
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String handleArithmeticException(Exception e) {
        //打印异常
//        log.error("异常是：{}",e.getMessage());
        //返回视图地址
        return "admin";
    }
}
