package com.example.sb_bookstore.utils;

import com.example.sb_bookstore.constants.ResultEnums;
import com.example.sb_bookstore.response.ResponseData;
import com.example.sb_bookstore.response.ResponseData2;

@SuppressWarnings("rawtypes")//去除使用原型的不安全警告
public class ResponseData2Util {
    //工具类一般都是静态方法，可以直接调用，不用实例化
    //正确的响应情况返回
    public  static  <T> ResponseData2 buildSuccess(int code , String msg, T data,long total){
        //带数据
        return new ResponseData2<T>(code, msg, data,total);
    }
    public static ResponseData2 buildSuccess(int code,String msg){
        //不带数据
        return new ResponseData2(code,msg);
    }

    public static  <T> ResponseData2 buildSuccess(T data,long total){
        //只带数据，如果不给出成功代码，默认使用Success的代码，即code=200，msg=“请求成功”
        return new ResponseData2<>(ResultEnums.SUCCESS.getCode(),ResultEnums.SUCCESS.getMsg(),data,total);
    }
    public static ResponseData2 buildSuccess(ResultEnums resultEnums){
        return new ResponseData2(resultEnums.getCode(),resultEnums.getMsg());
    }
    public static ResponseData2 buildSuccess(){
        //不带参数，默认是用SUCCESS
        return new ResponseData2(ResultEnums.SUCCESS);
    }

    //错误的情况返回数据
    public  static  <T> ResponseData2 buildError(int code ,String msg,T data,long total){
        //带数据
        return new ResponseData2<T>(code, msg, data,total);
    }
    public static ResponseData2 buildError(int code,String msg){
        //不带数据
        return new ResponseData2(code,msg);
    }
    public static  <T> ResponseData2 buildError(T data,long total){
        //只带数据，如果不给出成功代码，默认使用ERROR的代码，即code=400，msg=“请求失败”
        return new ResponseData2<>(ResultEnums.ERROR.getCode(),ResultEnums.ERROR.getMsg(),data,total);
    }
    public static ResponseData2 buildError(ResultEnums resultEnums){
        return new ResponseData2(resultEnums.getCode(),resultEnums.getMsg());
    }
    public static ResponseData2 buildError(){
        //不带参数，默认是用ERROR
        return new ResponseData2(ResultEnums.ERROR);
    }

}
