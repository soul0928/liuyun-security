package com.liuyun.utils.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @ProjectName liuyun-security
 * @ClassName ValidateCodeException
 * @Description 验证码异常类
 * @Author WangDong
 * @Date 2019/11/1 15:04
 * @Version 2.1.3
 **/
public class ValidateCodeException  extends AuthenticationException {

    private static final long serialVersionUID = 5022575393500654458L;

    ValidateCodeException(String message) {
        super(message);
    }

}
