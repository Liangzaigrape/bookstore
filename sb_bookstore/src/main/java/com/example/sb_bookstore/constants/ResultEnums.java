package com.example.sb_bookstore.constants;

import lombok.Getter;
@Getter
public enum ResultEnums {
    DEFAULT(1,"默认消息"),
    SUCCESS(200,"请求成功"),
    ERROR(400,"请求失败");
    private int code;//结果代码
    private String msg;//结果信息

    ResultEnums(int code, String msg){
        this.code=code;
        this.msg=msg;
    }

}
