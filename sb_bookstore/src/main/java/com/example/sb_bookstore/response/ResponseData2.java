package com.example.sb_bookstore.response;

import com.example.sb_bookstore.constants.ResultEnums;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseData2 <T> implements Serializable {
    private int code;//响应代码
    private String msg;//响应的消息
    private T data;//响应传递的数据
    //这里使用类型T，<T>作为泛化，代表以后使用的类型
    //total用于返回分页数据的总数
    private long total;
    public ResponseData2(int code,String msg, T data,long total){
        //带数据
        this.code=code;
        this.msg=msg;
        this.data=data;
        this.total=total;
    }
    public ResponseData2(int code,String msg){
        //不带数据
        this.code=code;
        this.msg=msg;
    }
    public ResponseData2(ResultEnums resultEnums,T data,long total){
        //带数据
        this.code=resultEnums.getCode();
        this.msg=resultEnums.getMsg();
        this.data=data;
        this.total=total;
    }
    public ResponseData2(ResultEnums resultEnums){
        //不带数据
        this.code= resultEnums.getCode();;
        this.msg=resultEnums.getMsg();
    }

}
