package com.renChao.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.renChao.pojo.Person;
import com.renChao.pojo.PersonType;
import com.renChao.pojo.Wife;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {


    @Test
    public void testBean() {
        Person person = new Person(1, "任超", new Wife(2, "王道月"));
        Gson gson = new Gson();
        //Bean => json
        String jsonStr = gson.toJson(person);
        System.out.println(jsonStr);
        //json =>  Bean
        Person p1 = gson.fromJson(jsonStr, Person.class);
        System.out.println(p1.getWife());
    }

    @Test
    void testList() {
        ArrayList<Person> peoples = new ArrayList<>();
        peoples.add(new Person(1, "任超", new Wife(2, "王道月")));
        peoples.add(new Person(2, "任超2", new Wife(2, "王道月2")));
        Gson gson = new Gson();
        //list => json
        String jsonStr = gson.toJson(peoples);
        System.out.println(jsonStr);
        //json =>  list
        List<Person> list = gson.fromJson(jsonStr, new TypeToken<List<Person>>(){}.getType());
        System.out.println(list);
    }

    @Test
    void testMap() {
        HashMap<Integer, Person> map = new HashMap<>();
        map.put(1, new Person(1, "任超", new Wife(2, "王道月")));
        map.put(2, new Person(2, "任超2", new Wife(2, "王道月2")));
        Gson gson = new Gson();
        //list => json
        String jsonStr = gson.toJson(map);
        System.out.println(jsonStr);
        //json =>  list
        Map<Integer, Person> map2 = gson.fromJson(jsonStr,new TypeToken<Map<Integer, Person>>(){}.getType());
        System.out.println(map2.get(1).getWife());
    }
    
    @Test
    public void testSerializedName() {
        String rc = "{\"user_ids\":1,\"name\":\"任超\",\"wife\":{\"id\":2,\"name\":\"王道月\"}}";
        Gson gson = new Gson();
        Person person = gson.fromJson(rc, Person.class);
        System.out.println(person);

        System.out.println(gson.toJson(person));
    }
}
