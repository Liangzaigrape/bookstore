package com.example.sb_bookstore.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
@Getter
@Setter
@TableName("comment")
@AllArgsConstructor
public class Comment {
    //处理Mysql自增的主键id
    @TableId(value = "id", type = IdType.AUTO)
    int id;
    int commentId;
    String content;
    @TableField(value = "comment_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",locale="zh",timezone="GMT+8")
    Date commentDate;
    @TableField(value = "user_id")
    int userId;
    @TableField(value = "book_id")
    int bookId;

}
