package com.example.sb_bookstore.service;

import com.example.sb_bookstore.domain.BookCategory;
import com.example.sb_bookstore.mapper.BookCategoryMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookCategoryService {
    @Autowired
    BookCategoryMapper bookCategoryMapper;

    //根据categoryid查查category

    public BookCategory getBookCategoryByCategoryId(Integer cid){
        return bookCategoryMapper.getCategoryByCategoryId(cid);
    };


    //遍历cid子孙具有的bookcategory
    public List<BookCategory> listCategories(Integer cid){
        return bookCategoryMapper.listCategories(cid);
    }

}
