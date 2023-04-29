package com.chaoRen.boot.config;

import com.chaoRen.boot.MyCar;
import com.chaoRen.boot.bean.Car;
import com.chaoRen.boot.bean.Person;
import com.chaoRen.boot.bean.Pet;
import com.chaoRen.boot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 * Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 * Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 * 组件依赖必须使用Full模式默认。其他默认是否Lite模式
 */

//告诉SpringBoot这是一个配置类 == 配置文件
@Configuration
//1、开启Car配置绑定功能
//2、把这个Car这个组件自动注册到容器中
@EnableConfigurationProperties({Car.class, Person.class})
@ConditionalOnProperty(prefix ="car", value = "brand")
public class MyConfig {


    private final Car car;

    public MyConfig(Car car) {
        this.car = car;
    }

    @Bean
    public MyCar myCar() {
        return new MyCar(car.getBrand(),car.getPrice());
    }

    @Bean
    public Pet pet01() {
        return new Pet("小猫", 3.2);
    }

    //容器中有pet01组件才进行装配
    @ConditionalOnBean(name = "pet01")
    @Bean
    public User user() {
        return new User("任超", 32, pet01());
    }
}
