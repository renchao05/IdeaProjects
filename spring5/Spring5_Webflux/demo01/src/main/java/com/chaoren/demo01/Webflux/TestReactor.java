package com.chaoren.demo01.Webflux;

import org.springframework.web.server.WebHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestReactor {
    public static void main(String[] args) {
        //just 方法直接声明
        Flux.just(1, 2, 3, 4);
        Mono.just(1);

        //其他的方法
        Integer[] array = {1,2,3,4};
        Flux.fromArray(array);

        List<Integer> list = Arrays.asList(array);
        Flux.fromIterable(list);
        Stream<Integer> stream = list.stream();
        Flux.fromStream(stream);

    }
}
