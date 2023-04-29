package com.chaoren.demo01.bean;

import lombok.Data;

@Data
public class Menu {
    private Long id;
    private String name;
    private String url;
    private Long parentId;
    private String permission;

}
