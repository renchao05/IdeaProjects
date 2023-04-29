package com.renchao.fund;

import com.renchao.fund.entity.Auth;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

public class Test01 {

    @Test
    public void testLocalDate() {
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);
    }

    @Test
    public void test02() {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(6);
        set.add(6);
        set.add(8);
        System.out.println(set);

    }
}
