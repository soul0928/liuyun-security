package com.liuyun.config.security;

import com.liuyun.utils.result.ResponseUtils;
import com.liuyun.utils.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName liuyun-security
 * @ClassName LiuYunAccessDeniedHandler
 * @Description  权限不足拦截
 * @Author WangDong
 * @Date 2019/11/4 9:52
 * @Version 2.1.3
 **/
@Slf4j
@Component
public class LiuYunAccessDeniedHandler implements AccessDeniedHandler {

    public static final String INSUFFICIENT_PERMISSIONS_MSG = "权限不足！！！";

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseUtils.out(response, Result.fail(HttpStatus.FORBIDDEN.value(), INSUFFICIENT_PERMISSIONS_MSG));
    }


}
