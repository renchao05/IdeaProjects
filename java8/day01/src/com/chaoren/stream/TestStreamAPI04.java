package com.chaoren.stream;

import com.chaoren.lambda.User;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestStreamAPI04 {
    List<User> users = Arrays.asList(
            new User(102, "李四", 79, 6666.66, Status.BUSY),
            new User(101, "张三", 18, 9999.99, Status.FREE),
            new User(103, "王五", 28, 3333.33, Status.VOCATION),
            new User(104, "赵六", 8, 7777.77, Status.BUSY),
            new User(104, "赵六", 8, 7777.77, Status.FREE),
            new User(104, "赵六", 8, 7777.77, Status.FREE),
            new User(105, "田七", 38, 5555.55, Status.BUSY)
    );
    @Test
    public void testToMap() {
        // distinct()去重，保证Key不会重复。
        Map<Integer, User> collect1 = users.stream().distinct().collect(Collectors.toMap(User::getId, user -> user));
        System.out.println(collect1);

        System.out.println("=====================");
        // Key有重复的处理情况
        Map<Integer, User> collect = users.stream().collect(Collectors.toMap(User::getId, user -> user,(k1,k2)->{
            System.out.println(k2);
            return k2;
        }));
        System.out.println("===========");
        System.out.println(collect);
    }




    /**
     * 	归约
     * 	reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
     */
    @Test
    public void test01() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> sum = list.stream().reduce(Integer::sum);
        System.out.println(sum);

        List<String> list2 = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        String str = list2.stream().reduce("A", (s1, s2) -> s1 + s2);
        System.out.println(str);

        IntStream intStream = users.stream().filter(a -> a.getAge() < 10).mapToInt(User::getAge);
        System.out.println(intStream);
    }

    /**
     * 收集
     * collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    @Test
    public void test02() {
        //获取list
        List<String> names1 = users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
        names1.forEach(System.out::println);

        //获取set对结果去重
        System.out.println("==============");
        Set<String> names2 = users.stream()
                .map(User::getName)
                .collect(Collectors.toSet());
        names2.forEach(System.out::println);

        //获取HashSet
        System.out.println("==============");
        HashSet<String> names3 = users.stream()
                .map(User::getName)
                .collect(Collectors.toCollection(HashSet::new));
        names3.forEach(System.out::println);
    }

    @Test
    public void test03() {
        //计数
        Long aLong = users.stream()
                .collect(Collectors.counting());
        System.out.println(aLong);

        //最大值maxBy，最小值minBy
        Optional<Double> max = users.stream()
                .map(User::getSalary)
                .collect(Collectors.maxBy(Double::compare));
        System.out.println(max);

        //求和summingDouble，平均值averagingDouble
        Double sum = users.stream()
                .collect(Collectors.summingDouble(User::getSalary));
        System.out.println(sum);

        //上面所有值
        DoubleSummaryStatistics dss = users.stream()
                .collect(Collectors.summarizingDouble(User::getSalary));
        System.out.println(dss);
    }

    @Test
    public void test04() {
        //分组
        Map<Status, List<User>> map1 = users.stream()
                .collect(Collectors.groupingBy(User::getStatus));
        map1.forEach((s,u) -> System.out.println(s + " : " + u));

        //多级分组
        System.out.println("=============");
        Map<Status, Map<String, List<User>>> map2 = users.stream()
                .collect(Collectors.groupingBy(User::getStatus, Collectors.groupingBy(e -> {
                    if (e.getAge() >= 60) {
                        return "老年";
                    } else if (e.getAge() >= 35) {
                        return "中年";
                    } else
                        return "成年";
                })));
        map2.forEach((s,aa) -> {
            System.out.println(s + " :");
            aa.forEach((a,u) -> System.out.println("\t" + a + " : " + u));
        });
    }

    @Test
    public void test05() {
        //分区
        Map<Boolean, List<User>> map = users.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() > 25));
        map.forEach((b,u) -> System.out.println(b + " : " + u));
    }

    @Test
    public void test06() {
        //字符串拼接
        String str = users.stream()
                .map(User::getName)
                .collect(Collectors.joining(",","==","=="));
        System.out.println(str);
    }

    @Test
    public void test07() {
        Optional<Double> collect = users.stream()
                .map(User::getSalary)
                .collect(Collectors.reducing(Double::sum));
        System.out.println(collect);
    }
}
