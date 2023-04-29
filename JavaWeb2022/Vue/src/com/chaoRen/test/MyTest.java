package com.chaoRen.test;

import com.chaoRen.pojo.Fruit;
import com.chaoRen.service.impl.FruitServiceImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        FruitServiceImpl fruitService = new FruitServiceImpl();
//        Fruit fruit1 = fruit.queryFruitById(5);
//        System.out.println(fruit1);
        Fruit fruit = new Fruit(null, "小苹果", 1, 33, "太小了");
        int i = fruitService.addFruit(fruit);
        System.out.println("=============  " + i);
    }

    @Test
    public void testJSON() {
        FruitServiceImpl fruitService = new FruitServiceImpl();
        List<Fruit> fruits = fruitService.queryFruits();
        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<Fruit>>(){}.getType();
        String json = gson.toJson(fruits, userListType);
        System.out.println(json);
    }
}
