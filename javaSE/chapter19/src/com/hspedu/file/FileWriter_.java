package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {

    @Test
    public void test01() throws IOException {
        FileWriter fileWriter = null;
        char[] chars = "风雨之后，定见彩虹".toCharArray();
        fileWriter = new FileWriter("d:\\note.txt");
        fileWriter.write(chars);
        fileWriter.close();
    }
}
