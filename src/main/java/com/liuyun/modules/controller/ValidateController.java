package com.liuyun.modules.controller;

import com.liuyun.config.redis.RedisUtils;
import com.liuyun.constants.RedisLoginConstants;
import com.liuyun.utils.code.ImageCodeUitls;
import com.liuyun.utils.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName liuyun-security
 * @ClassName ValidateController
 * @Description
 * @Author WangDong
 * @Date 2019/11/1 13:48
 * @Version 2.1.3
 **/
@Slf4j
@RestController
@RequestMapping(value = "/validate")
public class ValidateController {

    @Autowired
    private RedisUtils redisUtils;

    @Value("${liuyun.login.code.expire_time}")
    private Integer expireTime;

    @GetMapping("/code/image")
    public void createCode(String uuid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (StringUtils.isBlank(uuid)) {
            throw new GlobalException("uuid不能为空！！！");
        }
        String verifyCode = ImageCodeUitls.generateVerifyCode(4);
        redisUtils.set(RedisLoginConstants.LIUYUN_LOGIN_CODE + uuid, verifyCode, expireTime);
        try {
            ImageCodeUitls.outputImage(request, response, verifyCode);
        } catch (ServletException e) {
            log.error("获取图片验证码失败 [{}]", e.getMessage());
        }
    }

}
