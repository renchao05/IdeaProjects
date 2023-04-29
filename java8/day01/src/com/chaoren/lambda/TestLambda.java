package com.chaoren.lambda;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class TestLambda {

    @Test
    public void test01() {
        Runnable run = () -> System.out.println("你好，任超！！");
        run.run();
    }

    @Test
    public void test02() {
        Consumer<String> f = (args) -> System.out.println(args);
        f.accept("你好，任超！");
    }

    @Test
    public void test03() {
        BinaryOperator<Integer> bo = (x, y) -> {
            System.out.println("实现函数接口方法。");
            return x + y;
        };
        System.out.println(bo.apply(5, 9));
    }

    @Test
    public void test04() {
        String s = toUpperString((e) -> e.toUpperCase(), "abcde！");
        System.out.println(s);
    }

    public String toUpperString(MyFunc<String> mf, String str) {
        return mf.getValue(str);
    }


    @Test
    public void test05() {
        //例如:
        Consumer<String> sum1 = (e) -> System.out.println(e);
        //等同于
        Consumer<String> sum = System.out::println;
        sum.accept("你好，任超。。。。。");
    }

    @Test
    public void test06() {
        //例如:
        BinaryOperator<Double> bo = (x, y) -> Math.pow(x, y);
        //等同于
        BinaryOperator<Double> bo1 = Math::pow;
    }

    @Test
    public void test07() {
        //例如:
        BiFunction<String, String, Boolean> fun = (x, y) -> x.equals(y);
        //等同于
        BiFunction<String, String, Boolean> fun1 = String::equals;
        Boolean apply = fun.apply("sss", "sss");
        System.out.println(apply);
    }

    @Test
    public void test08() {
        //例如:
        BiFunction<String, Integer, User> fun = (x, y) -> new User(x, y);
        //等同于
        BiFunction<String, Integer, User> fun1 = User::new;

        User user = fun1.apply("任超", 23);
        System.out.println(user);
    }

    @Test
    public void test09() {
        //例如:
        Function<Integer, String[]> fun = (x) -> new String[x];
        //等同于
        Function<Integer, String[]> fun1 = String[]::new;

        System.out.println(fun1.apply(66).length);
    }
}
