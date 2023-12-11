package com.example.sb_bookstore.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sb_bookstore.domain.Book;

import com.example.sb_bookstore.domain.BookCategory;
import com.example.sb_bookstore.domain.Comment;
import com.example.sb_bookstore.response.ResponseData2;
import com.example.sb_bookstore.service.BookCategoryService;
import com.example.sb_bookstore.service.BookService;
import com.example.sb_bookstore.service.CommentService;
import com.example.sb_bookstore.utils.RandomUtil;
import com.example.sb_bookstore.utils.ResponseData2Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouterController {
    @Autowired
    BookService bookService;
    @Autowired
    BookCategoryService bookCategoryService;
    @Autowired
    CommentService commentService;
    @RequestMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping("/book/new")
    public List<Book> getNewBooks() {
        return bookService.getNewBooks();
    }

    @RequestMapping("/book/hot")
    public List<Book> getHotBooks() {
        return bookService.getHotBooks();
    }

    @RequestMapping("/book/teach")
    public List<Book> getTeachBooks() {
        return bookService.getTeachBooks();
    }


    @RequestMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") Integer id) {
        if (id != null)
            return bookService.getBookById(id);
        return null;
    }
//    ***此处修改代码，增加代码，为List，返回书籍list
    @RequestMapping("/book/category/{cid}")
    public List<Book> getBooksByCategoryId(@PathVariable("cid") Integer cid){
        return bookService.getBooksByCategoryId(cid);
    }
        //    分页查询
        @RequestMapping("/book/category/{cid}/page")
        public ResponseData2 getBooksByCategoryId(@PathVariable("cid") Integer cid,
                                                  @RequestParam(defaultValue = "1") Integer pageNum,
                                                  @RequestParam(defaultValue = "5") Integer pageSize

        ){
            Page<Book> books = bookService.selectPageByCategory(new Page<>(pageNum, pageSize), cid);
             return ResponseData2Util.buildSuccess(books.getRecords(),books.getTotal());
         }

         //不分页查询
    @RequestMapping("/search")
    public List<Book> searchBooks(@RequestParam(value = "keyword",required = false) String keyword ){
        //** 修改 wd=> keyword
        //因为前端用了keyword作为传递参数的命名，所以这里用keyword，保持对应关系,
        // required=false表示可以有keyword，也可以没有keyword
        if(keyword!=null &&!"".equals(keyword) )
        {
            return bookService.searchBooks(keyword);
        }
        //不加条件则空
        return null;
    }
    //分页查询
    @RequestMapping("/search/page")
    //获得搜索结果的总数
    public ResponseData2 countBySearch(@RequestParam(value = "keyword",required = false) String keyword,
                                  @RequestParam(defaultValue = "1") Integer pageNum,
                                  @RequestParam(defaultValue = "5") Integer pageSize
    ){
        //       默认分页大小为5，当前页为1
        if(keyword!=null &&!"".equals(keyword) )
        {
            Page<Book> books = bookService.selectPageBySearch(new Page<>(pageNum, pageSize), keyword);
            return ResponseData2Util.buildSuccess(books.getRecords(),books.getTotal());
        }
        //不加条件则空
        return ResponseData2Util.buildError();
    }

    @RequestMapping("/categories")
    public List<BookCategory> getAllCategories(){
        //0 表示根，就是查出所有
        return bookCategoryService.listCategories(0);
    }

    @RequestMapping("/category/{cid}")
    public BookCategory getBookCategoryByCategoryId(@PathVariable("cid") Integer cid){
       return  bookCategoryService.getBookCategoryByCategoryId(cid);
    }


    @RequestMapping("/comments")
    public List<Comment> getAllComments(){return commentService.getAllComments();}

    @RequestMapping("/comment/{cid}")
    public Comment getCommentByCommentId(@PathVariable("cid") Integer cid){
        return commentService.getCommentByCommentId(cid);
    }
    @RequestMapping("/book/{bid}/comment")
    public List<Comment> getCommentsByBookId(@PathVariable("bid") Integer bid){
        return commentService.getCommentsByBookId(bid);
    }
    @RequestMapping("/user/{uid}/comment")
    public List<Comment> getCommentsByUserId(@PathVariable("uid") Integer uid){

        return commentService.getCommentsByUserId(uid);
    }
    @RequestMapping("/test")
    public int test(){
        return RandomUtil.getRandom();
    }


}
