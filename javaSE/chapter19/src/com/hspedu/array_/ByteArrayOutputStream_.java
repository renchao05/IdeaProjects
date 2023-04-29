package com.hspedu.array_;

import com.hspedu.OutputStream_.Dog;
import org.junit.jupiter.api.Test;

import java.io.*;

public class ByteArrayOutputStream_ {
    @Test
    public void test01() throws IOException, ClassNotFoundException {
        Dog dog = new Dog("大大狗", 2);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(dog);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object o = ois.readObject();
        Dog dog1 = (Dog) o;
        System.out.println(dog == dog1);
    }
}
