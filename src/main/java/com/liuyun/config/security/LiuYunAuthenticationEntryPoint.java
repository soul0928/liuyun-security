package com.liuyun.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liuyun.utils.result.ResponseUtils;
import com.liuyun.utils.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName liuyun-security
 * @ClassName LiuYunAuthenticationEntryPoint
 * @Description
 * @Author WangDong
 * @Date 2019/10/31 13:43
 * @Version 2.1.3
 **/
@Slf4j
@Component
public class LiuYunAuthenticationEntryPoint implements AuthenticationEntryPoint {

    public static final String NEED_LOGIN_MSG = "请先登录！！！";


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseUtils.out(response, Result.fail(HttpStatus.UNAUTHORIZED.value(), NEED_LOGIN_MSG));
    }
}
