package com.liuyun.config.security;

import com.liuyun.modules.pojo.entity.LiuYunUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ProjectName liuyun-security
 * @ClassName LiuYunUserDetailService
 * @Description 自定义用户认证
 * @Author WangDong
 * @Date 2019/10/29 11:26
 * @Version 2.1.3
 **/
@Slf4j
@Configuration
public class LiuYunUserDetailService implements UserDetailsService {

    /**
     * 密码加密接口
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LiuYunUserEntity user = getUser(username);
        log.info("加密后的密码 [{}]", user.getPassword());
        // 模拟一个admin的权限，该方法可以将逗号分隔的字符串转换为权限集合
        return new User(username, user.getPassword(), user.getEnabled(),
                user.getAccountNonExpired(), user.getCredentialsNonExpired(),
                user.getAccountNonLocked(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

    /**
     * @description 模拟数据库查询
     * @author 王栋
     * @date 2019/10/29 14:05
     * @param
     * @return com.liuyun.modules.pojo.entity.LiuYunUserEntity
     **/
    private LiuYunUserEntity getUser(String userName) {
        LiuYunUserEntity liuYunUserEntity = new LiuYunUserEntity();
        liuYunUserEntity.setUserName(userName);
        //  密码加密
        liuYunUserEntity.setPassword(this.passwordEncoder.encode("123456"));
        return liuYunUserEntity;
    }
}
