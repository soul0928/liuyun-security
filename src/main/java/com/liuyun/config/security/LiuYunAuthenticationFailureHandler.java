package com.liuyun.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liuyun.utils.result.ResponseUtils;
import com.liuyun.utils.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName liuyun-security
 * @ClassName LiuYunAuthenticationFailureHandler
 * @Description 自定义登录失败
 * @Author WangDong
 * @Date 2019/10/29 14:15
 * @Version 2.1.3
 **/
@Slf4j
@Component
public class LiuYunAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper mapper;

    /**
     * @description  身份验证失败时调用
     * @author 王栋
     * @date 2019/10/29 14:16
     * @param request
     * @param response
     * @param exception
     * @return void
     **/
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Result result = new Result();
        //返回json数据
        if (exception instanceof AccountExpiredException) {
            //账号过期
            result = Result.fail(HttpStatus.UNAUTHORIZED.value(), "账号已过期!!!");
        } else if (exception instanceof BadCredentialsException) {
            //密码错误
            result = Result.fail(HttpStatus.UNAUTHORIZED.value(), "密码错误!!!");
        } else if (exception instanceof CredentialsExpiredException) {
            //密码过期
            result = Result.fail(HttpStatus.UNAUTHORIZED.value(), "密码过期!!!");
        } else if (exception instanceof DisabledException) {
            //账号不可用
            result = Result.fail(HttpStatus.UNAUTHORIZED.value(), "账号不可用!!!");
        } else if (exception instanceof LockedException) {
            //账号锁定
            result = Result.fail(HttpStatus.UNAUTHORIZED.value(), "账号锁定!!!");
        } else if (exception instanceof InternalAuthenticationServiceException) {
            //用户不存在
            result = Result.fail(HttpStatus.UNAUTHORIZED.value(), "用户不存在!!!");
        }else{
            //其他错误
            result = Result.fail("位置异常！！！");
        }
        ResponseUtils.out(response, result);
    }
}
