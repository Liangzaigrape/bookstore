package com.example.sb_bookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sb_bookstore.domain.BookCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface BookCategoryMapper extends BaseMapper<BookCategory> {
    //插入一个类别
    public int addCategoryReturnId(BookCategory bookCategory);

    @Select("select * from bookcategory where category_id=#{cid}")
    public BookCategory getCategoryByCategoryId(Integer cid);

    //便利cid的子孙类别
    @Select("select * from bookcategory where  parent_id =#{cid}")
    @Results({
//            多表查询，这里结果为1对n，所以是many=  @Many
            @Result(column = "category_id",property = "categoryId"),
            @Result(column="category_id",property = "children",
                    many=@Many(select = "com.example.sb_bookstore.mapper.BookCategoryMapper.listCategories")
            )
    })
    public List<BookCategory> listCategories(Integer cid);
}
