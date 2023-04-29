package com.hspedu.mhl.domain;


/**
 * id INT PRIMARY KEY AUTO_INCREMENT,
 * 	`name` VARCHAR(50) NOT NULL DEFAULT '',
 * 	`type` VARCHAR(50) NOT NULL DEFAULT '',
 * 	price DOUBLE NOT NULL DEFAULT 0
 */
public class Menu {
    private Integer id;
    private String name;
    private String type;
    private Double price;

    @Override
    public String toString() {
        return id + "\t\t\t" + name + "\t\t" + type + "\t\t" + price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Menu(Integer id, String name, String type, Double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Menu() {}
}
