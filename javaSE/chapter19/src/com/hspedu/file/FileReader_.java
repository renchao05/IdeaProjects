package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {

    public static void main(String[] args) {
        FileReader fileReader = null;
        int c = 0;
        char[] ch = new char[5];
        try {
            fileReader = new FileReader("d:\\chao.txt");
            while ((c = fileReader.read(ch)) != -1) {
                System.out.print(new String(ch, 0, c));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test01() throws IOException {
        FileReader fileReader = null;
        int length = 0;
        char[] cbuf = new char[5];
        fileReader = new FileReader("d:\\chao.txt");
        while ((length = fileReader.read(cbuf)) != -1) {
            System.out.print(new String(cbuf, 0, length));
        }
        fileReader.close();
    }

    @Test
    public void m5() throws IOException {
        FileReader fileReader = null;
        fileReader = new FileReader("d:\\chao.txt");
        System.out.println((char) fileReader.read());
        System.out.println((char) fileReader.read());
        fileReader.close();
        System.out.println((char) fileReader.read());
        System.out.println((char) fileReader.read());
        System.out.println((char) fileReader.read());
        System.out.println((char) fileReader.read());
    }
}
