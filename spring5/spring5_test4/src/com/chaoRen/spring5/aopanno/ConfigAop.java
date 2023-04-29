package com.chaoRen.spring5.aopanno;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.chaoRen.spring5.aopanno"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
