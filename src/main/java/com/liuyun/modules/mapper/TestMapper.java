package com.liuyun.modules.mapper;

import com.liuyun.modules.pojo.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ProjectName liuyun-security
 * @ClassName TestMapper
 * @Description TODO
 * @Author WangDong
 * @Date 2019/9/27 14:00
 * @Version 2.1.3
 **/
@Mapper
public interface TestMapper {

    List<TestEntity> queryAll();

}
