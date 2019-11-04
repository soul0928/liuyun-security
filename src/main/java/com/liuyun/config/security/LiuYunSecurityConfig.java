package com.liuyun.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

/**
 * @ProjectName liuyun-security
 * @ClassName BrowserSecurityConfig
 * @Description
 * @Author WangDong
 * @Date 2019/10/29 11:02
 * @Version 2.1.3
 **/
@Slf4j
@Configuration
public class LiuYunSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 自定义登录成功
     */
    @Autowired
    private LiuYunAuthenticationSuccessHandler liuYunAuthenticationSuccessHandler;

    /**
     * 自定义登录失败
     */
    @Autowired
    private LiuYunAuthenticationFailureHandler liuYunAuthenticationFailureHandler;

    /**
     * 未登录
     */
    @Autowired
    private LiuYunAuthenticationEntryPoint liuYunAuthenticationEntryPoint;

    /**
     * @description 重写 Spring Security提供的Web应用安全配置的适配器
     * @author 王栋
     * @date 2019/10/29 11:17
     * @param http
     * @return void
     **/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling().authenticationEntryPoint(liuYunAuthenticationEntryPoint) //
                .and().authorizeRequests()
                .and().formLogin()
                .loginProcessingUrl("/login")
                .successHandler(liuYunAuthenticationSuccessHandler) // 登录成功处理
                .failureHandler(liuYunAuthenticationFailureHandler) // 登录失败处理
                .and().authorizeRequests() // 授权配置
                .antMatchers(openPath()).permitAll()
                .anyRequest()  // 所有请求
                .authenticated()// 都需要认证
                .and().csrf().disable()
        ;

    }

    /**
     * @description 该对象用于密码加密，注入前需要手动配置
     * @author 王栋
     * @date 2019/10/29 13:48
     * @param
     * @return org.springframework.security.crypto.password.PasswordEncoder
     **/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public String[] openPath() {
        ArrayList<String> list = new ArrayList<>();
        // 获取图片验证码路径
        list.add("/validate/code/image");

        String[] array = new String[list.size()];
        return list.toArray(array);
    }

}
