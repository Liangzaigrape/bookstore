package com.example.sb_bookstore.exception;

import jakarta.servlet.http.HttpServletResponse;
import com.example.sb_bookstore.response.ResponseData;
import com.example.sb_bookstore.utils.ResponseDataUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.Arrays;

@ControllerAdvice
public class CustomExceptionHandler {

    @ResponseBody
    @ExceptionHandler(CustomException.class)
    public ResponseData myCustomException(CustomException e, HttpServletResponse resp) {
        //这里使用工具类ResponseDataUtil返回Response数据
        return ResponseDataUtil.buildError(e.getErrorCode(),e.getErrorMsg(),"出现异常了，请检查您的数据或操作！");
    }
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseData handleAllException(Exception e,HttpServletResponse resp){
        return ResponseDataUtil.buildError(e.getMessage()+ Arrays.stream(e.getStackTrace()).toList());
    }

}
