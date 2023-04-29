package com.hspedu.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        byte[] s = new byte[100];
        int i = 0;
        try {
            inputStream = new FileInputStream("d:\\如何阅读一本书.jpg");
            outputStream = new FileOutputStream("e:\\sss.jpg",true);
            while ((i = inputStream.read(s)) != -1) {
                outputStream.write(s,0,i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
