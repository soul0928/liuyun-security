package com.liuyun.config.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

/**
 * @ProjectName liuyun-security
 * @ClassName RedisUtils
 * @Description
 * @Author WangDong
 * @Date 2019/11/1 10:58
 * @Version 2.1.3
 **/
@Slf4j
@Component
public class RedisUtils {

    @Autowired
    private Jedis jedis;

    /**
     * @description set
     * @author 王栋
     * @date 2019/9/26 14:46
     * @param key
     * @param value
     * @return java.lang.String
     **/
    public String set(String key, String value) {
        try {
            return jedis.set(key, value);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * @description set
     * @author 王栋
     * @date 2019/9/26 14:39
     * @param key key
     * @param value value
     * @param timeOut 过期时间 单位：秒
     * @return java.lang.String
     **/
    public String set(String key, String value, int timeOut) {
        try {
            SetParams setParams = new SetParams();
            setParams.ex(timeOut);
            return jedis.set(key, value,setParams);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * @description get
     * @author 王栋
     * @date 2019/9/26 14:48
     * @param key
     * @return java.lang.String
     **/
    public String get(String key) {
        try {
            return jedis.get(key);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }

    }


}
