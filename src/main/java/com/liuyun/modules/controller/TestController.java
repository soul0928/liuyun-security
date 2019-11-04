package com.liuyun.modules.controller;

import com.liuyun.config.redis.RedisUtils;
import com.liuyun.modules.pojo.entity.TestEntity;
import com.liuyun.modules.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName liuyun-security
 * @ClassName TestController
 * @Description
 * @Author WangDong
 * @Date 2019/9/27 13:26
 * @Version 2.1.3
 **/
@Slf4j
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping(value = "queryAll")
    public List<TestEntity> queryAll() {
        System.out.println(redisUtils.set("aaa", "bbbb"));
        System.out.println(redisUtils.get("aaa"));
        return testService.queryAll();
    }
}
