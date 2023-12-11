package com.example.sb_bookstore.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sb_bookstore.domain.Book;
import com.example.sb_bookstore.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;
    public int addBook(Book book){
        //注意的是，这里返回的是插入成功的记录条数
        //return bookMapper.insert(book);
        if( bookMapper.addBookReturnBookId(book)!=0)
            return book.getBookId();//返回图书的book_id
        return 0;
    }
    public int updateBook(Book book){
        return bookMapper.updateById(book);
    }

    public List<Book> getAllBooks(){
        return bookMapper.selectList(null);
    }
    public Book getBookById(Integer id){return bookMapper.getBookById(id);}
    public  List<Book> getNewBooks(){return  bookMapper.getNewBooks();}
    public  List<Book> getHotBooks(){return  bookMapper.getHotBooks();}
    public  List<Book> getTeachBooks(){return  bookMapper.getTeachBooks();}
    public List<Book> searchBooks(String keyword){
        //select * from book where title like XXX or author like XXX or brief like XXX or book_concern like XXX
        QueryWrapper<Book> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("title",keyword);
        queryWrapper.or();
        queryWrapper.like("author",keyword);
        queryWrapper.or();
        queryWrapper.like("brief",keyword);
        queryWrapper.or();
        queryWrapper.like("book_concern",keyword);
        return bookMapper.selectList(queryWrapper);
    }
    //修改增加代码
    public List<Book> getBooksByCategoryId(Integer cid){
        return bookMapper.getBooksByCategoryId(cid);
    }
    public Page<Book> selectPageBySearch(Page<Book> page, String keyword){
        QueryWrapper<Book> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("title",keyword);
        queryWrapper.or();
        queryWrapper.like("author",keyword);
        queryWrapper.or();
        queryWrapper.like("brief",keyword);
        queryWrapper.or();
        queryWrapper.like("book_concern",keyword);
        return bookMapper.selectPage(page,queryWrapper);
    }
    public Page<Book> selectPageByCategory(Page<Book> page,Integer cid){
        QueryWrapper<Book> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("category_id",cid);
        return bookMapper.selectPage(page,queryWrapper);
    }

}
