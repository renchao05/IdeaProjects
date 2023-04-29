package com.hspedu.collection;

import java.util.ArrayList;
import java.util.List;

public class ListExercise02 {
    public static void main(String[] args) {
        List books = new ArrayList();
        books.add(new Book("金瓶梅", 45, "兰陵笑笑生"));
        books.add(new Book("水浒传", 25, "施耐庵"));
        books.add(new Book("三国志", 34, "罗贯中"));
        books.add(new Book("青年报", 12, "出版社"));
        Object obj = new Object();
        for (int i = 0; i < books.size() - 1; i++) {
            for (int j = 0; j < books.size() - i - 1; j++) {
                if (((Book)books.get(j)).getPrice() > ((Book)books.get(j + 1)).getPrice()) {
                    obj = books.get(j);
                    books.set(j,books.get(j + 1));
                    books.set(j + 1, obj);
                }
            }
        }
        for (Object o : books) {
            System.out.println(o);
        }

    }
}

class Book {
    private String name;
    public double price;
    private String author;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    @Override
    public String toString() {
        return "名称：" + name +
                "\t \t价格：" + price +
                "\t \t作者：" + author;
    }
}