package com.hspedu.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream_ {

    @Test
    public void m1() {
        int i = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("d:\\news2.txt");
            while ((i = fileInputStream.read()) != -1)
                System.out.print((char) i);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void m2() {
        byte[] i = new byte[8];
        int l = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("d:\\news2.txt");
            while ((l = fileInputStream.read(i)) != -1)
                System.out.print(new String(i,0,l));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileInputStream != null;
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
