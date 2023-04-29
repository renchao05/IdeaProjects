package com.chaoren.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户太多了。。")
public class UsersToManyException extends RuntimeException {

}
