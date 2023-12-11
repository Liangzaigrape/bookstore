package com.example.sb_bookstore.domain;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@TableName(value = "book")
public class Book {
    //处理Mysql自增的主键id
    @TableId(value = "id", type = IdType.AUTO)
    int id;
    /**
     *指定列名,若一致可以不用指定
     * 这里使用了驼峰写法，而数据库字段名为book_id,
     * 也可以不用指定列名，可以关联的，默认驼峰和下划线可以自动识别
     */
    @TableField(value = "book_id")
    int bookId;
    String title;
    String author;
    float price;
    float discount;
    String image;

    String bookConcern;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",locale="zh",timezone="GMT+8")
    Date publishDate;
    String brief;
    int categoryId;
//全参构造函数
    public Book(int id, int bookId, String title, String author, float price, float discount, String image, String bookConcern, Date publishDate, String brief, int categoryId) {
        this.id = id;
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.discount = discount;
        this.image = image;
        this.bookConcern = bookConcern;
        this.publishDate = publishDate;
        this.brief = brief;
        this.categoryId = categoryId;
    }
    //无参构造函数
    public Book(){}
    //不带id的构造参数
    public Book(int bookId, String title, String author, float price, float discount, String image, String bookConcern, Date publishDate, String brief, int categoryId) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.discount = discount;
        this.image = image;
        this.bookConcern = bookConcern;
        this.publishDate = publishDate;
        this.brief = brief;
        this.categoryId = categoryId;
    }

}
