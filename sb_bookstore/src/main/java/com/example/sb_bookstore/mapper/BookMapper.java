package com.example.sb_bookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sb_bookstore.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper extends BaseMapper<Book> {




    @Select("select * from book where id=#{id}")
    public Book getBookById(int id);


    public int addBookReturnBookId(Book book);

    public List<Book> getNewBooks();
    public List<Book> getHotBooks();
    public List<Book> getTeachBooks();
    //增加代码
    @Select("select * from book where category_id=#{cid}")
    public List<Book> getBooksByCategoryId(int cid);

}
