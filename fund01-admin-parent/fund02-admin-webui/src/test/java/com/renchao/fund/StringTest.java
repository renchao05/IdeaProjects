package com.renchao.fund;

import com.renchao.fund.exception.LoginFailedException;
import com.renchao.fund.util.CrowdUtil;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class StringTest {

    @Test
    public void testMD5() {
        String str = "123";
        String md5 = CrowdUtil.md5(str);
        System.out.println(md5);
        throw new LoginFailedException("登陆错误！！！！");
    }

    @Test
    public void test01() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123");
        System.out.println(encode);
    }
}
