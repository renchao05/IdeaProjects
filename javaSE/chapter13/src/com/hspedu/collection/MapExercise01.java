package com.hspedu.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapExercise01 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Map map = new HashMap();
        for (int i = 1; i <= 12 ; i++) {
            map.put(new DD(i),"你好！");
        }
    }
}

class DD {
    private int name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DD dd = (DD) o;
        return Objects.equals(name, dd.name);
    }

    @Override
    public int hashCode() {
        return 100055;
    }

    public DD(int name) {
        this.name = name;
    }
}