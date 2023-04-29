package com.renchao.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动创建
@EnableDiscoveryClient
//@EnableFeignClients
@MapperScan({"com.renchao.springcloud.dao"}) // 必须
public class SeataStorageServiceApp2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageServiceApp2002.class, args);
    }
}
