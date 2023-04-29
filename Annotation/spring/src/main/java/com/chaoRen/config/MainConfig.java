package com.chaoRen.config;

import com.chaoRen.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(value = "com.chaoRen", excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})},
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})})
public class MainConfig {
    @Bean
    public Person person() {
        return new Person("小明", 24);
    }
}
