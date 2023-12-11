package com.example.sb_bookstore.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@TableName("bookcategory")
public class BookCategory {
    //处理Mysql自增的主键id
    @TableId(value = "id", type = IdType.AUTO)
    int id;
    @TableField(value = "category_id")
    int categoryId;

    @TableField(value = "parent_id")
    int parentId;
    @TableField(value = "category_name")
    String categoryName;
    //这里用来存放子类别，不是表bookcategory的字段
    @TableField(exist = false)
    private List<BookCategory> children;

    public BookCategory(int categoryId,String categoryName,int parentId){

        this.parentId=parentId;
        this.categoryId=categoryId;
        this.categoryName=categoryName;
    }
    public BookCategory(int id,int categoryId,String categoryName,int parentId){
        this.id=id;
        this.parentId=parentId;
        this.categoryId=categoryId;
        this.categoryName=categoryName;
    }
}
