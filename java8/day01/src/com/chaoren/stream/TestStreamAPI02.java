package com.chaoren.stream;

import com.chaoren.lambda.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamAPI02 {

    List<User> users = Arrays.asList(
            new User(102, "e李四", 59, 6666.66),
            new User(101, "z张三", 18, 9999.99),
            new User(103, "a王五", 28, 3333.33),
            new User(104, "g赵六", 6, 7777.77),
            new User(104, "g赵六", 8, 7777.77),
            new User(104, "g赵六", 8, 7777.77),
            new User(105, "c田七", 38, 5555.55)
    );

    /**
     * 筛选与切片
     * filter——接收 Lambda ， 从流中排除某些元素。
     * limit——截断流，使其元素不超过给定数量。
     * skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
     * distinct——去除重复元素 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
     */
    @Test
    public void test01() {
        System.out.println("=========filter==============");
        Stream<User> stream1 = users.stream().filter(e -> e.getAge() > 20);
        stream1.forEach(System.out::println);

        System.out.println("==========limit=============");
        Stream<User> stream2 = users.stream().filter(e -> e.getAge() > 20).limit(2);
        stream2.forEach(System.out::println);

        System.out.println("==========skip(n)=============");
        Stream<User> stream3 = users.stream().filter(e -> e.getAge() > 20).skip(2);
        stream3.forEach(System.out::println);

        System.out.println("==========distinct=============");
        Stream<User> stream4 = users.stream().distinct();
        stream4.forEach(System.out::println);
    }

    /**
     * sorted()——自然排序(Comparable)
     * sorted(Comparator com)——定制排序
     */
    @Test
    public void test03() {
        List<String> list = Arrays.asList("bbb", "ccc", "aaa", "ddd");
        list.stream().sorted()
                .forEach(System.out::println);

        System.out.println("====================");
        users.stream().sorted((e1,e2) -> {
            if (e1.getName().equals(e2.getName())) {
                return e1.getAge().compareTo(e2.getAge());
            } else {
                return e1.getName().compareTo(e2.getName());
            }
        }).forEach(System.out::println);
    }

    @Test
    public void test031() {
        Date d1 = new Date(1661344856000L);
        Date d2 = new Date(1661344858000L);
        Date d3 = new Date(1661344854000L);
        List<Date> list = Arrays.asList(d1, d2, d3);
        list.forEach(date -> System.out.println(date.getTime()));
        System.out.println("===================");
        List<Date> collect = list.stream().sorted((e1, e2) -> (int) (e1.getTime() - e2.getTime())).collect(Collectors.toList());
        collect.forEach(date -> System.out.println(date.getTime()));

    }



    /**
     * 映射
     * map——接收 Lambda ， 将元素转换成其他形式或提取信息。
     * 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */
    @Test
    public void test02() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        users.stream().map(User::getName).forEach(System.out::println);

        // 流中流
        System.out.println("========map:Stream<Stream<Character>>=========");
        Stream<Stream<Character>> stream = list.stream().map(TestStreamAPI02::filterCharacter);
        stream.forEach(e -> e.forEach(System.out::println));

        // 然后把所有流连接成一个流
        System.out.println("========flatMap:Stream<Character>==========");
        Stream<Character> stream1 = list.stream().flatMap(TestStreamAPI02::filterCharacter);
        stream1.forEach(System.out::println);
        

    }

    // 把字符串转换成流
    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

}
