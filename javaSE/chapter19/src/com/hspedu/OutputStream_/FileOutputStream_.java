package com.hspedu.OutputStream_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_ {
    FileOutputStream file = null;

    @Test
    public void writer() {
        try {
            String str = "===========hello,good morning!\n";
            file = new FileOutputStream("d:\\chao.txt",true);
            file.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
