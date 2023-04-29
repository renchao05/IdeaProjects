package com.hspedu.OutputStream_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\dat.dat"));
        oos.writeInt(100);
        oos.writeUTF("任超");
        oos.writeDouble(100);
        oos.writeBoolean(true);
        oos.writeObject(new Dog("小黄",3));
        oos.close();
    }
}