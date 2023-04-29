package com.hspedu.transformation;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

public class InputStreamReader_ {

    @Test
    public void test01() throws IOException {
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("d:\\a.txt"), "GBK");
//        BufferedReader br = new BufferedReader(isr);
//        Stream<String> stream = br.lines();
//        stream.forEach(System.out::println);


        String str = "hello,任超！！";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d:\\b.txt"), "GBK");
        osw.write(str);
        osw.close();
    }
}
