package com.liuyun.modules.pojo.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @ProjectName liuyun-security
 * @ClassName TestEntity
 * @Description
 * @Author WangDong
 * @Date 2019/9/27 14:02
 * @Version 2.1.3
 **/
@Data
@Alias("TestEntity")
public class TestEntity {

    private Long id;
    private String name;
    private Date birthday;

}
