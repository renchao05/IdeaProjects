package com.chaoRen.collectiontype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
    private String[] arr;
    private List<String> list;
    private Map<Integer,String> map;
    private Set<String> set;
    private List<Food> foods;

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void show() {
        System.out.println(Arrays.toString(arr));
        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
        System.out.println(foods);
    }
}
