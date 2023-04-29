package com.hspedu.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1,new Worker("任超",20000,1));
        hashMap.put(2,new Worker("王道月",6000,2));
        hashMap.put(3,new Worker("任子馨",0,3));
        hashMap.put(4,new Worker("任传睿",0,4));
        Set set = hashMap.keySet();
        for (Object o : set) {
            if (hashMap.get(o) instanceof Worker) {
                Worker worker = (Worker)hashMap.get(o);
                if (worker.getSal() > 18000)
                    System.out.println(worker);
            }
        }
        System.out.println("============entrySet的for=============");
        Set set1 = hashMap.entrySet();
        for (Object o : set1) {
            Map.Entry entry = (Map.Entry)o;
            Worker value = (Worker)entry.getValue();
            if (value.getSal() > 1800)
                System.out.println(value);

        }


    }
}

class Worker {
    private String name;
    private int sal;
    private int id;

    public int getSal() {
        return sal;
    }

    @Override
    public String toString() {
        return name;
    }

    public Worker(String name, int sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }
}