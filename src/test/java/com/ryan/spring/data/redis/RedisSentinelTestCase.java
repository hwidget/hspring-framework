package com.ryan.spring.data.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/21 16:46.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:data/spring-data-redis-sentinel.xml"})
public class RedisSentinelTestCase {
    private static final Logger LOG = LoggerFactory.getLogger(RedisSentinelTestCase.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testRandomWrite() throws Exception {
        ValueOperations<String, String> operations = null;
        while (true){
            try {
                operations = this.redisTemplate.opsForValue();
                operations.set(UUID.randomUUID().toString(), "1");
            } catch (Exception e) {
                e.printStackTrace();
            }
            LOG.info("正在写入数据……当前时间:{}", System.currentTimeMillis());
            Thread.sleep(3 * 1000);
        }

    }
}
