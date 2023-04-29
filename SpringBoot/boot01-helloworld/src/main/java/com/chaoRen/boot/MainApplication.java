package com.chaoRen.boot;


import com.chaoRen.boot.bean.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序类
 * SpringBootApplication：这是一个SpringBoot应用
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //1、返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2、查看容器里面的组件
//        String[] names = run.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
//        System.out.println("=========================================");
//        String[] names = run.getBeanNamesForType(Car.class);
//        System.out.println(names.length);
//
//        System.out.println("=========================================");
//        MyCar myCar = run.getBean("myCar", MyCar.class);
//        System.out.println(myCar);


        //3、从容器中获取组件
//        User user = run.getBean("user", User.class);
//        User user2 = run.getBean("user", User.class);
//        System.out.println("user是否一样：" + (user == user2));
//        Pet pet01 = run.getBean("pet01", Pet.class);
//        System.out.println("user的pet与pet是否一样：" + (user.getPet() == pet01));
//        System.out.println("===================");
//        String[] type = run.getBeanNamesForType(User.class);
//        for (String s : type) {
//            System.out.println(s);
//        }
//        System.out.println("===================");
//        DBHelper bean = run.getBean(DBHelper.class);
//        System.out.println(bean);
//        System.out.println("容器中是否有pet01：" + run.containsBean("pet01"));
//        System.out.println("容器中是否有user：" + run.containsBean("user"));
//        System.out.println("容器中是否有pet02：" + run.containsBean("pet2"));
//        System.out.println("容器中是否有user2：" + run.containsBean("user2"));

    }
}
