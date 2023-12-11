package com.example.sb_bookstore.service;

import com.example.sb_bookstore.domain.User;
import com.example.sb_bookstore.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User getUserByUserId(Integer uid){
        return userMapper.getUserByUserId(uid);
    }
    public User getUserByUserName(String uname){
        return userMapper.getUserByUserName(uname);
    }
    public User getUserByUserNameAndPassword(String uname,String password){
        return  userMapper.getUserByUserNameAndPassword(uname,password);
    }
    public int addUserReturnId(User user){
        return  userMapper.addUserReturnId(user);
    }
}
