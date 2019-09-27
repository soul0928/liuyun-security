package com.liuyun.modules.service;

import com.liuyun.modules.pojo.entity.TestEntity;

import java.util.List;

/**
 * @ProjectName liuyun-security
 * @ClassName TestService
 * @Description TODO
 * @Author WangDong
 * @Date 2019/9/27 13:57
 * @Version 2.1.3
 **/
public interface TestService {

    List<TestEntity> queryAll();
}
