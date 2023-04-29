package com.chaoren.datasource.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chaoren.datasource.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lombok注解
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
public class User {
    @TableId("id")
    private Long uid;
    @TableField("username")
    private String name;
    private Integer age;
    private SexEnum sex;
    private String email;
    @TableLogic
    private Integer isDeleted;

    //兼容之前代码
    public User(Long uid, String name, Integer age, String email, Integer isDeleted) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.email = email;
        this.isDeleted = isDeleted;
    }
}
