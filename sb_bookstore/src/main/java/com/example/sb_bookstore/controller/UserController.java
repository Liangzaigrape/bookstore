package com.example.sb_bookstore.controller;

import com.example.sb_bookstore.domain.User;
import com.example.sb_bookstore.response.ResponseData;
import com.example.sb_bookstore.service.UserService;
import com.example.sb_bookstore.utils.RandomUtil;
import com.example.sb_bookstore.utils.ResponseDataUtil;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/user/{uname}")
    public ResponseData isExistUser(@PathVariable("uname") String uname){
        //这里的参数 是用户名，判断该用户是否存在，根据前端，这里都要返回code=200的查询成功信息
        //如果用户存在，返回data=true，否则data=false
        if(userService.getUserByUserName(uname)!=null)
            return ResponseDataUtil.buildSuccess(200,"用户已存在",true);;
        return ResponseDataUtil.buildSuccess(200,"用户不存在",false);
    }
    @RequestMapping("/user/login")
    public ResponseData isLogin( @RequestBody(required = false) Map params){
        //根据前端，正确的code返回200，data为user数据，密码错误返回400，失败返回500
        if(params==null)
            return ResponseDataUtil.buildError(400,"参数为空，请检查传递数据方式，不可直接用form");
        String uname=params.get("username").toString();
        String password=params.get("password").toString();
        if(uname==null||"".equals(uname)||"".equals(password)||password==null)
            return ResponseDataUtil.buildError(400,"请求失败");
        User user=userService.getUserByUserNameAndPassword(uname,password);
        if(user!=null){
            return ResponseDataUtil.buildSuccess(200,"登录成功",user);
        } else if (userService.getUserByUserName(uname)!=null) {
            return ResponseDataUtil.buildError(400,"密码错误");
        }
        return ResponseDataUtil.buildError(500,"登录失败");
    }
    @RequestMapping("/user/register")
    public ResponseData register(@RequestBody Map params){
        //前端传递了3个值过来
        if(params==null)
            return ResponseDataUtil.buildError(400,"参数为空，请检查传递数据方式，不可直接用form");
        String uname=params.get("username").toString();
        String password=params.get("password").toString();
        String mobile=params.get("mobile").toString();
        if(uname==null||"".equals(uname)||"".equals(password)||password==null||mobile==null||"".equals(mobile))
            return ResponseDataUtil.buildError(400,"用户名，密码和手机号码数据均不能为空");
        if(userService.getUserByUserName(uname)!=null) return ResponseDataUtil.buildError(400,"用户名已经存在");
        User user=new User(uname,"example@example.com",password, new Date(), RandomUtil.getRandom(),mobile,"user");

        int id=userService.addUserReturnId(user);
        //这个时候，正常的话，id会给回到user
        if(id!=0)
            return ResponseDataUtil.buildSuccess(200,"注册成功",user);
        return ResponseDataUtil.buildError(500,"注册失败");
    }
}
