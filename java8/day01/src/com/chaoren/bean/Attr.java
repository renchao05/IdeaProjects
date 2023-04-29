package com.chaoren.bean;

public class Attr {
    private Integer skuId;
    private Integer id;
    private String name;
    private String value;

    public Attr(Integer skuId, String name, String value) {
        this.skuId = skuId;
        this.name = name;
        this.value = value;
    }

    public Attr(Integer skuId, Integer id, String name, String value) {
        this.skuId = skuId;
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Attr() {
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Attr{" +
                "skuId=" + skuId +
//                ", id=" + id +
//                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
