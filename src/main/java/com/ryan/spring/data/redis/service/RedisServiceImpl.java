package com.ryan.spring.data.redis.service;

import com.google.common.collect.Maps;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2017/2/28 16:51.
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Override
    @Cacheable(value = "test", key = "'cc-'+#id")
    public String hello(String id) {
        System.err.println("该方法执行了。");

        return "hello, " + id;
    }


    @Override
    @Cacheable(value = "test", key = "'users-'+#uid")
    public Map<String, Object> listUsers(String uid){
        HashMap<String, Object> users = new HashMap<>();

        users.put("userId", uid);
        users.put("uname", "Ryan");

        return users;
    }

}
