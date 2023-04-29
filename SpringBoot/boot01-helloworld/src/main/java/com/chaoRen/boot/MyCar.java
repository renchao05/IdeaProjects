package com.chaoRen.boot;

import lombok.Data;
import org.springframework.context.annotation.Conditional;

@Data
public class MyCar {
    private String brand;
    private Integer price;

    public MyCar(String brand, Integer price) {
        this.brand = brand;
        this.price = price;
    }
}
