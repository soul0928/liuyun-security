package com.liuyun.config.web;

import com.liuyun.utils.exception.GlobalException;
import com.liuyun.utils.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ProjectName liuyun-security
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常拦截
 * @Author WangDong
 * @Date 2019/11/1 14:35
 * @Version 2.1.3
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @Description 处理自定义异常
     * @Author 王栋
     * @Date 2019/4/27 14:44
     * @param: GlobalException
     * @return DataResult
     **/
    @ExceptionHandler(GlobalException.class)
    public Result handleGlobalException(GlobalException e) {
        log.info("Exception Is [{}]", e.getMessage());
        return Result.fail(e.getCode(), e.getMessage());
    }


}
