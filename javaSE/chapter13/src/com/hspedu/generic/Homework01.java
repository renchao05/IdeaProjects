package com.hspedu.generic;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Homework01 {
    public static void main(String[] args) {
        DAO<String> dao = new DAO<>();
        dao.save("任超","王道月");
        dao.save("no1","任超");
        System.out.println(dao.list());
    }
    @Test
    public void work() {
        DAO<User> dao = new DAO<>();
        dao.save("no1",new User(1,23,"任超"));
        dao.save("no2",new User(2,25,"王道月"));
        dao.save("no3",new User(3,33,"大大"));

        System.out.println(dao.get("no2"));
        System.out.println(dao.list());
        dao.update("no2",new User(2,22,"美女"));
        System.out.println(dao.list());
        dao.delete("no3");
        System.out.println(dao.list());
    }
}

class DAO<T> {
    private Map<String,T> map = new HashMap<>();
    public void save(String id, T entity) {
        map.put(id,entity);
    }
    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id,entity);
    }
    public List<T> list() {
        Set<String> strings = map.keySet();
        ArrayList<T> ts = new ArrayList<>();
        for (String o : strings) {
            ts.add(map.get(o));
        }
        return ts;
    }

    public void delete(String id) {
        map.remove(id);
    }

    @Override
    public String toString() {
        return "DAO{" +
                "map=" + map +
                '}';
    }
}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}