package com.example.sb_bookstore.service;

import com.example.sb_bookstore.domain.Comment;
import com.example.sb_bookstore.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;
    public List<Comment> getAllComments(){return commentMapper.selectList(null);}
    public Comment getCommentByCommentId(Integer cid){return  commentMapper.getCommentByCommentId(cid);}
    public List<Comment> getCommentsByBookId(Integer bid){
        return commentMapper.getCommentsByBookId(bid);
    }
    public List<Comment> getCommentsByUserId(Integer uid){
        return  commentMapper.getCommentsByUserId(uid);
    }

}
