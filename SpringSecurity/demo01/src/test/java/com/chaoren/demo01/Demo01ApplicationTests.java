package com.chaoren.demo01;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class Demo01ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test01() {
        //创建密码解析器
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //对密码进行加密
        String chaoRen = encoder.encode("1234");
        //打印加密后的密码
        System.out.println(chaoRen);
        //判断原字符加密后与加密前是否匹配
        boolean b = encoder.matches("chaoRen", chaoRen);
        //打印匹配结果
        System.out.println(b);

        System.out.println(chaoRen.equals("$2a$10$luqVbKhnB9kl7U8HKZYLI.6In/ZX5Uk.Q2jG0xlVwO2cpnPE9p2Wm"));
    }
}
