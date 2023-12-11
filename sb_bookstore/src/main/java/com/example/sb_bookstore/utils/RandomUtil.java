package com.example.sb_bookstore.utils;

import java.util.UUID;

public class RandomUtil {
    public static int getRandom(){
        //位数9，int最大的位数，使用UUID产生随机整数
        int bits=9;
        // 生成UUID
        int  temp=UUID.randomUUID().toString().replace("-","").hashCode();
        temp=temp<0?-temp:temp;
        String tempStr=Integer.toString(temp);
        while(tempStr.length()<bits){
            tempStr=tempStr+(int)(Math.random()*10);
        }
        if(tempStr.length()>bits){
            tempStr=tempStr.substring(0,bits);
        }
        return Integer.parseInt(tempStr);
    }

}
