package com.example.sb_bookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sb_bookstore.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    @Select("select * from comment where comment_id=#{cid}")
    public Comment getCommentByCommentId(Integer cid);

    @Select("select * from comment where book_id=#{bid}")
    public List<Comment> getCommentsByBookId(Integer bid);


    @Select("select * from comment where user_id=#{uid}")
    public List<Comment> getCommentsByUserId(Integer uid);


}
