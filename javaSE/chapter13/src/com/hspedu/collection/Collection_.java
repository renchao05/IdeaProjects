package com.hspedu.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Collection_ {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add("任超");
        col.add("王道月");
        col.add("任子馨");
        col.add("任传睿");
        System.out.println(col);
        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
        for (Object i : col)
            System.out.println(i);

        for (Object o : col) {
            System.out.println(o);
        }

    }
}
