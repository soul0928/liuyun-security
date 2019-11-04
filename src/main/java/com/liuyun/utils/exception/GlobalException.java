package com.liuyun.utils.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * @ProjectName liuyun-security
 * @ClassName exception
 * @Description 自定义异常
 * @Author WangDong
 * @Date 2019/11/1 14:36
 * @Version 2.1.3
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = -2651641612755181121L;

    private Integer code = HttpStatus.INTERNAL_SERVER_ERROR.value();

    public GlobalException(String msg) {
        super(msg);
    }

    public GlobalException(String msg, Throwable e) {
        super(msg, e);
    }

    public GlobalException(String msg, int code) {
        super(msg);
        this.code = code;
    }

    public GlobalException(String msg, int code, Throwable e) {
        super(msg, e);
        this.code = code;
    }
}

