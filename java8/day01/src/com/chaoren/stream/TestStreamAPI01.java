package com.chaoren.stream;

import com.chaoren.bean.Attr;
import com.chaoren.lambda.User;
import org.junit.Test;

import javax.swing.plaf.PanelUI;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamAPI01 {

    //创建Stream
    @Test
    public void test01() {
        //1、通过 Collection 系列提供的 stream() 或 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2、通过 Arrays 中的静态方法 stream() 获取数组流
        User[] users = new User[10];
        Stream<User> stream2 = Arrays.stream(users);

        //3、通过Stream类中的静态方法of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc", "dd");

        //4、创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0, x -> x + 2);
        stream4.limit(20).forEach(System.out::println);

        //生成
        Stream<Double> stream5 = Stream.generate(Math::random);
        stream5.limit(14).forEach(System.out::println);

    }

    /**
     * id  sku_id  attr_id  attr_name  attr_value  attr_sort
     * ------  ------  -------  ---------  ----------  -----------
     * 15       8        6  颜色         白色               (NULL)
     * 16       8        8  型号2        8GB+128GB        (NULL)
     * 17       9        6  颜色         白色               (NULL)
     * 18       9        8  型号2        6GB+128GB        (NULL)
     * 19      10        6  颜色         黑色               (NULL)
     * 20      10        8  型号2        8GB+128GB        (NULL)
     * 21      11        6  颜色         黑色               (NULL)
     * 22      11        8  型号2        6GB+128GB        (NULL)
     */

    @Test
    public void test02() {
        byte a = 5;
        byte b = 7;
        b = a + b;
        b += a;

    }
}
