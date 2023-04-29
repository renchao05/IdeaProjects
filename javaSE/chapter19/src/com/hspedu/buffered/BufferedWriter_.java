package com.hspedu.buffered;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class BufferedWriter_ {


    @Test
    public void test01() throws IOException {
        String str = "hello,任超你找到了你喜欢的事情";
        Stream<String> stream = Stream.of("hello_01", "hello_02", "hello_03", "hello_04");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:\\chao.txt", true));
        stream.forEach(s -> {
            try {
                bufferedWriter.write(s + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }); //写入流
        bufferedWriter.write(str + "\n");  //写入一行字符串
        bufferedWriter.close();
    }
}
