package com.liuyun.modules.pojo.entity;

import lombok.Data;

/**
 * @ProjectName liuyun-security
 * @ClassName LiuYunUserEntity
 * @Description
 * @Author WangDong
 * @Date 2019/10/29 11:24
 * @Version 2.1.3
 **/
@Data
public class LiuYunUserEntity {

    private String userName;

    private String password;

    /**
     * 指示用户的帐户是否已过期
     */
    private Boolean accountNonExpired = true;

    /**
     * 指示用户是是否锁定
     */
    private Boolean accountNonLocked = true;

    /**
     * 指示用户的凭据（密码）是否已过期
     */
    private Boolean credentialsNonExpired = true;

    /**
     * 指示用户是启用还是禁用
     */
    private Boolean enabled = true;

}
