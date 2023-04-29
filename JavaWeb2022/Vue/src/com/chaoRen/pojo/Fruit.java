package com.chaoRen.pojo;

public class Fruit {
    private Integer fid ;
    private String name;
    private Integer price ;
    private Integer count;
    private String remark ;

    public Fruit(){}

    public Fruit(Integer fid, String name, Integer price, Integer count, String remark) {
        this.fid = fid;
        this.name = name;
        this.price = price;
        this.count = count;
        this.remark = remark;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return fid + "\t\t" + name + "\t\t" + price +"\t\t" + count +"\t\t" + remark ;
    }
}
