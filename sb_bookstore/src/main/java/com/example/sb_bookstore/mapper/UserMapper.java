package com.example.sb_bookstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sb_bookstore.domain.User;
import lombok.Setter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where user_id=#{uid}")
    public User getUserByUserId(Integer uid);

    @Select("select * from user where user_name=#{uname}")
    public User getUserByUserName(String uname);

    //根据用户名和密码找用户，即用来判断登录
    @Select("select * from user where user_name=#{uname} and password=#{password}")
    public User getUserByUserNameAndPassword(String uname,String password);

    //插入一个用户，即注册功能
    public int addUserReturnId(User user);
}
