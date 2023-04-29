package com.renChao.pojo;


import com.google.gson.annotations.SerializedName;

public class Person {
//    @SerializedName(value = "user_id",alternate = {"user_ids"})
    private Integer id;
    private String name;
    private Wife wife;

    public Person(Integer id, String name, Wife wife) {
        this.id = id;
        this.name = name;
        this.wife = wife;
    }

    public Person() {
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

    public Wife getWife() {
        return wife;
    }

    public void setPerson(Wife wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wife=" + wife +
                '}';
    }
}
