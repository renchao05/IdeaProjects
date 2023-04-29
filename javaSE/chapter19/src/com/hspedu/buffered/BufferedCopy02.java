package com.hspedu.buffered;

import java.io.*;

public class BufferedCopy02 {
    public static void main(String[] args) throws IOException {
        byte[] b = new byte[1024];
        int i = 0;
        BufferedInputStream bi = new BufferedInputStream(new FileInputStream("e:\\谷歌云重置.mp4"));
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream("d:\\谷歌云.mp4"));
        while ((i = bi.read(b)) != -1) {
            bo.write(b,0,i);
        }
        bi.close();
        bo.close();
    }
}
