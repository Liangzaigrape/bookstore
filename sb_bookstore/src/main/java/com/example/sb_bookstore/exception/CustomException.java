package com.example.sb_bookstore.exception;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustomException extends Exception{
    private int errorCode=0;//异常错误代码
    private String errorMsg="";//异常错误信息
    public CustomException(int errorCode,String errorMsg){
        super();
        //因为异常Exception错误代码code是用的String类型，这里做个转换
        this.errorCode=errorCode;
        this.errorMsg=errorMsg;
    }
    public CustomException(String errorMsg){
        super();
        this.errorMsg=errorMsg;
    }

}
