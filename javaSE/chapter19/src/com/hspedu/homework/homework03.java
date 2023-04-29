package com.hspedu.homework;

import java.io.*;
import java.util.Properties;

public class homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties pr = new Properties();
        pr.load(new FileReader("d:\\dog.properties"));
        Dog dog = new Dog(pr.getProperty("name"),
                Integer.decode(pr.getProperty("age")), pr.getProperty("color"));
//        System.out.println(dog);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\dat.dat"));
        oos.writeObject(dog);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\dat.dat"));
        System.out.println("===================");
        System.out.println(ois.readObject());
    }
}

class Dog implements Serializable{
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}