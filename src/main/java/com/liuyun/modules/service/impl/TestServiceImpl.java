package com.liuyun.modules.service.impl;

import com.liuyun.modules.mapper.TestMapper;
import com.liuyun.modules.pojo.entity.TestEntity;
import com.liuyun.modules.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName liuyun-security
 * @ClassName TestServiceImpl
 * @Description
 * @Author WangDong
 * @Date 2019/9/27 13:59
 * @Version 2.1.3
 **/
@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<TestEntity> queryAll() {
        return testMapper.queryAll();
    }
}
