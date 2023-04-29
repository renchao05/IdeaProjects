package com.chaoRen.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  //告诉Spring这是配置类
//开启组件扫描
@ComponentScan(basePackages = {"com.chaoRen.spring5"})
public class SpringConfig {
}
