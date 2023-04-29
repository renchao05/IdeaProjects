package com.hspedu.inputstream_;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        byte[] b = new byte[3];
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\dat.dat"));
        System.out.println(ois.readInt());
        System.out.println(ois.readUTF());
        System.out.println(ois.readDouble());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readObject());
    }
}
