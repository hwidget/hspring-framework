package com.ryan.spring.data.redis.service;

import java.util.Map;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2017/2/28 16:51.
 */
public interface RedisService {

    public String hello(String id);

    /**
     * @param uid
     * @return
     */
    public Map<String, Object> listUsers(String uid);
}
