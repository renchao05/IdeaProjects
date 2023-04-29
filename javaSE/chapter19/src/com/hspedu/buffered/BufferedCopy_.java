package com.hspedu.buffered;

import java.io.*;

public class BufferedCopy_ {
    public static void main(String[] args) throws IOException {
        String str = "";
        BufferedReader bufferedReader = new BufferedReader(new FileReader("d:\\chao.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("e:\\chao.txt"));
        while ((str = bufferedReader.readLine()) != null) {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
