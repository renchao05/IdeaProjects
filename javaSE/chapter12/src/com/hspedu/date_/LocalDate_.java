package com.hspedu.date_;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class LocalDate_ {
    public static void main(String[] args) {
//        LocalDate ldt = LocalDate.now();
//        System.out.println(ldt);
//        System.out.println(LocalTime.now());
//        System.out.println(LocalDateTime.now());

        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(Date.from(now));
    }
}
