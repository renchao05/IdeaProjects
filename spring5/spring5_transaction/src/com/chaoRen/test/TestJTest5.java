package com.chaoRen.test;

import com.chaoRen.spring5.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:bean1.xml")
public class TestJTest5 {

    @Autowired
    UserService userService;

    @Test
    public void testJ() {
        userService.transferAccounts("任超","王道月",200.0);
    }
}
