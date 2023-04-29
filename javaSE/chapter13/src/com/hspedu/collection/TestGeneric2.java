package com.hspedu.collection;

import java.util.*;

public class TestGeneric2 {
    public static void main(String[] args) {
        HashMap<String,Student> student = new HashMap<String,Student>();
        student.put("任超",new Student("RENCHAO"));
        student.put("王道月",new Student("WANGDAOYUE"));
        Set<String> strings = student.keySet();
        for (String s : strings) {
            System.out.println(s + "=" + student.get(s));
        }
        System.out.println("====================");
        Set<Map.Entry<String, Student>> set = student.entrySet();
        for (Map.Entry entry : set) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        System.out.println("=========迭代器============");
        Iterator<Map.Entry<String, Student>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next = iterator.next();
            System.out.println(next.getKey() + "=" + next.getValue());
        }
    }
}

class Student {
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public Student(String name) {
        this.name = name;
    }
}