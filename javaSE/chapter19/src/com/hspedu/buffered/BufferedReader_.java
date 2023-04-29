package com.hspedu.buffered;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class BufferedReader_ {
    @Test
    public void test01() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("d:\\note.txt"));
        //返回一个 Stream
        Stream<String> lines = bufferedReader.lines();
        lines.forEach(System.out::println);

        //整行读取
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
    }
}
