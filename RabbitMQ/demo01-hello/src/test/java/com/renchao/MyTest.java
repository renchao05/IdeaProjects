package com.renchao;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MyTest {
    public static void main(String[] args) {
        ConcurrentSkipListMap<Long, String> outstandingConfirms = new ConcurrentSkipListMap<>();

        for (int i = 0; i < 100; i++) {
            outstandingConfirms.put((long) (i * 100), i + "");
        }
        ConcurrentNavigableMap<Long, String> confirmed = outstandingConfirms.headMap(500L, true);
        //清除该部分未确认消息
        confirmed.clear();
    }
}
