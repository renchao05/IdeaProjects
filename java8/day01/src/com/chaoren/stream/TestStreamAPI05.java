package com.chaoren.stream;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.OptionalLong;
import java.util.stream.LongStream;

public class TestStreamAPI05 {
    @Test
    public void test01() {

        Instant start = Instant.now();
        OptionalLong reduce = LongStream.rangeClosed(0, 10000000000L)
                .parallel()
                .reduce(Long::sum);
        Instant end = Instant.now();
        System.out.println("耗时：" + Duration.between(start,end).toMillis());
    }
}
