package com.hspedu.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;

public class Homework05 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        DDD rc = new DDD("任超", 32);
        hashSet.add(rc);
        System.out.println(hashSet);
        rc.n2 = 25;
        hashSet.remove(rc);
        System.out.println(rc.n2);
        System.out.println(hashSet);
    }
}


class DDD {
    public String name;
    public int n2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DDD ddd = (DDD) o;
        return n2 == ddd.n2 &&
                Objects.equals(name, ddd.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, n2);
    }

    @Override
    public String toString() {
        return "DDD{" +
                "name='" + name + '\'' +
                ", n2=" + n2 +
                '}';
    }

    public DDD(String name, int n2) {
        this.name = name;
        this.n2 = n2;
    }
}