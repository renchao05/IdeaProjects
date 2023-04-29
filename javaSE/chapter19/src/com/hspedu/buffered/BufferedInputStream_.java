package com.hspedu.buffered;

import org.junit.jupiter.api.Test;

import java.io.*;

public class BufferedInputStream_ {
    @Test
    public void test01() throws FileNotFoundException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("d:\\chao.txt"));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("d:\\chao.txt"));

    }
}
