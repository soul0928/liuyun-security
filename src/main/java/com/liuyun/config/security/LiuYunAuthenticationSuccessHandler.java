package com.liuyun.config.security;

import com.liuyun.utils.result.ResponseUtils;
import com.liuyun.utils.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName liuyun-security
 * @ClassName LiuYunAuthenticationSuccessHandler
 * @Description 自定义登录成功后处理
 * @Author WangDong
 * @Date 2019/11/1 11:07
 * @Version 2.1.3
 **/
@Slf4j
@Component
public class LiuYunAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * @description 登录成功后处理
     * @author 王栋
     * @date 2019/11/1 11:08
     * @param request
     * @param response
     * @param authentication
     * @return void
     **/
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        ResponseUtils.out(response, Result.success());

    }
}
