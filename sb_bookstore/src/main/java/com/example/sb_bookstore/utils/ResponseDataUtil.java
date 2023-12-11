package com.example.sb_bookstore.utils;

import com.example.sb_bookstore.constants.ResultEnums;
import com.example.sb_bookstore.response.ResponseData;
@SuppressWarnings("rawtypes")//去除使用原型的不安全警告
public class ResponseDataUtil {
    //工具类一般都是静态方法，可以直接调用，不用实例化
    //正确的响应情况返回
    public  static  <T> ResponseData buildSuccess(int code ,String msg,T data){
        //带数据
        return new ResponseData<T>(code, msg, data);
    }
    public static ResponseData buildSuccess(int code,String msg){
        //不带数据
        return new ResponseData(code,msg);
    }

    public static  <T> ResponseData buildSuccess(T data){
        //只带数据，如果不给出成功代码，默认使用Success的代码，即code=200，msg=“请求成功”
        return new ResponseData<>(ResultEnums.SUCCESS.getCode(),ResultEnums.SUCCESS.getMsg(),data);
    }
    public static ResponseData buildSuccess(ResultEnums resultEnums){
        return new ResponseData(resultEnums.getCode(),resultEnums.getMsg());
    }
    public static ResponseData buildSuccess(){
        //不带参数，默认是用SUCCESS
        return new ResponseData(ResultEnums.SUCCESS);
    }

    //错误的情况返回数据
    public  static  <T> ResponseData buildError(int code ,String msg,T data){
        //带数据
        return new ResponseData<T>(code, msg, data);
    }
    public static ResponseData buildError(int code,String msg){
        //不带数据
        return new ResponseData(code,msg);
    }
    public static  <T> ResponseData buildError(T data){
        //只带数据，如果不给出成功代码，默认使用ERROR的代码，即code=400，msg=“请求失败”
        return new ResponseData<>(ResultEnums.ERROR.getCode(),ResultEnums.ERROR.getMsg(),data);
    }
    public static ResponseData buildError(ResultEnums resultEnums){
        return new ResponseData(resultEnums.getCode(),resultEnums.getMsg());
    }
    public static ResponseData buildError(){
        //不带参数，默认是用ERROR
        return new ResponseData(ResultEnums.ERROR);
    }

}
