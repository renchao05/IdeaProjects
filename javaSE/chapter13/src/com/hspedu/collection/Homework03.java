package com.hspedu.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Homework03 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack",650);
        m.put("tom",1200);
        m.put("smith",2900);
        System.out.println(m);
        m.put("jack",2600);
        System.out.println(m);
        Set set = m.keySet();
        for (Object o : set) {
            m.put(o,(int)m.get(o) + 100);
        }
        System.out.println(m);

        for (Object o : set) {
            System.out.println("员工：" + o);
        }

        for (Object o : set) {
            System.out.println(o + "=" + m.get(o));
        }


    }
}
