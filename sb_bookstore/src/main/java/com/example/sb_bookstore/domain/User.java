package com.example.sb_bookstore.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@TableName("user")
@Setter
@Getter
public class User {
    String userName;
    String email;
    String password;
    @TableField(value = "create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",locale="zh",timezone="GMT+8")
    Date createTime;
    int userId;
    String mobile;
    //处理Mysql自增的主键id
    @TableId(value = "id", type = IdType.AUTO)
    int id;
    String role;

    public User(String userName, String email, String password, Date createTime, int userId, String mobile, int id, String role) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.createTime = createTime;
        this.userId = userId;
        this.mobile = mobile;
        this.id = id;
        this.role = role;
    }

    public User(String userName, String email, String password, Date createTime, int userId, String mobile, String role) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.createTime = createTime;
        this.userId = userId;
        this.mobile = mobile;
        this.role = role;
    }
}
