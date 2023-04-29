package com.chaoren.stream;

import com.chaoren.lambda.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TestStreamAPI03 {
    List<User> users = Arrays.asList(
            new User(102, "李四", 79, 6666.66, Status.BUSY),
            new User(101, "张三", 18, 9999.99, Status.FREE),
            new User(103, "王五", 28, 3333.33, Status.VOCATION),
            new User(104, "赵六", 8, 7777.77, Status.BUSY),
            new User(104, "赵六", 8, 7777.77, Status.FREE),
            new User(104, "赵六", 8, 7777.77, Status.FREE),
            new User(105, "田七", 38, 5555.55, Status.BUSY)
    );

    /**
     * 	allMatch——检查是否匹配所有元素
     * 	anyMatch——检查是否至少匹配一个元素
     * 	noneMatch——检查是否没有匹配的元素
     * 	findFirst——返回第一个元素
     * 	findAny——返回当前流中的任意元素【串行是第一个，并行是随机】
     * 	count——返回流中元素的总个数
     * 	max——返回流中最大值
     * 	min——返回流中最小值
     * 	parallel
     */
    @Test
    public void test02() {
        System.out.println(users.stream().findAny());
        System.out.println(users.stream().sequential().findAny());
    }



    @Test
    public void test01() {
        //allMatch——检查是否匹配所有元素
        System.out.println("======allMatch——检查是否匹配所有元素======");
        boolean b1 = users.stream().allMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(b1);

        System.out.println("======anyMatch——检查是否至少匹配一个元素======");
        //anyMatch——检查是否至少匹配一个元素
        boolean b2 = users.stream().anyMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(b2);

        System.out.println("======noneMatch——检查是否没有匹配的元素======");
        //noneMatch——检查是否没有匹配的元素
        boolean b3 = users.stream().noneMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(b3);

        System.out.println("======findFirst——返回第一个元素======");
        //findFirst——返回第一个元素
        Optional<User> op = users.stream().filter(e -> e.getStatus().equals(Status.FREE)).findFirst();
        System.out.println(op.get());

        System.out.println("======findAny——返回当前流中的任意元素======");
        //findAny——返回当前流中的任意元素
        Optional<User> any = users.stream().findAny();
        System.out.println(any.get());

        System.out.println("======count——返回流中元素的总个数======");
        //count——返回流中元素的总个数
        long count = users.stream().filter(e -> e.getStatus().equals(Status.FREE)).count();
        System.out.println(count);

        System.out.println("======max——返回流中最大值======");
        //max——返回流中最大值
        Optional<Integer> max = users.stream().map(User::getAge).max(Integer::compare);
        System.out.println(max.get());

        System.out.println("=====min——返回流中最小值=======");
        //min——返回流中最小值
        Optional<Double> min = users.stream().map(User::getSalary).min(Double::compare);
        System.out.println(min);
    }
}
