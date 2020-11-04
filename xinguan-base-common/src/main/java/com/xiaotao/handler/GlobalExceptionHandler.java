package com.xiaotao.handler;

import com.xiaotao.response.Result;
import com.xiaotao.response.ResultCodeImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /*
     * 全局异常处理
     **/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
//        e.printStackTrace();
        log.error(e.getMessage());
        return Result.error();
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e) {
        log.error(e.getMessage());
        return Result.error().code(ResultCodeImpl.ARITHMETIC_EXCEPTION.getCode())
                .message(ResultCodeImpl.ARITHMETIC_EXCEPTION.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result error(BusinessException e) {
        log.error(e.getErrMsg());
        return Result.error().code(e.getCode())
                .message(e.getErrMsg());
    }

}