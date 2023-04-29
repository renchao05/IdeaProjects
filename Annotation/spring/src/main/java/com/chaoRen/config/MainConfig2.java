package com.chaoRen.config;

import com.chaoRen.bean.Person;
import org.springframework.context.annotation.*;

@Configuration
@ImportResource("classpath:beans.xml")
public class MainConfig2 {
    @Bean
    public Person person() {
        return new Person("小明", 24);
    }
}
