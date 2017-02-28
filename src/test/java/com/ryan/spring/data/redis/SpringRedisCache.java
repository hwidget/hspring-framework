package com.ryan.spring.data.redis;

import com.google.common.collect.Sets;
import com.ryan.spring.data.redis.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2017/2/28 16:41.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:data/spring-data-redis-dist.xml"})
public class SpringRedisCache {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testCache() throws Exception {

//        for (int i = 0; i < 10; i++) {
//            String ids = redisService.hello(UUID.randomUUID().toString());
//            System.err.println("ID : " + ids);
//        }

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        Set keys = redisTemplate.keys("*");

        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();


        for (Object key : keys) {
            System.err.println("key : " + key);

            String keyStr = key.toString().substring(((String) key).indexOf("cc-"));
            System.err.println("keyStr : " + keyStr);

            String s = opsForValue.get("%" + keyStr);
            System.out.println(s);

        }
    }

    @Test
    public void testGetCache() throws Exception {
        HashSet<String> keys = Sets.newHashSet("f3698046-4e6c-4dbe-849a-47cc2337cd99", "9622b268-dcef-4ed0-beae-0e7bbbecb9ab",
                "571bdb5a-f517-4aad-8b79-cafb32fc4906", "4abb2a5f-51f1-4fcd-885a-7438c034392a", "de33eb04-e1f1-4d23-9c75-bdf851e68f28",
                "2d563b65-2ac8-400c-9060-cf65536deb42", "9e3ef1ce-f1b6-407f-aa41-06cfee973602", "6f175dc1-c78b-49bf-937f-eeb4a9b20a1d",
                "47339b38-dfd4-425a-9f5f-d3bd9f1affb1", "dc3362e8-1178-4dbe-a94d-32835cf38de5");

        for (String key : keys) {
            String hello = redisService.hello(key);
            System.err.println("Response : " + hello);
        }
    }

    /**
     * 测试缓存Map数据
     *
     * @throws Exception
     */
    @Test
    public void testCacheMap() throws Exception {

        Map<String, Object> users = redisService.listUsers("0001");
        System.out.println("缓存 Map 结果: " + users);

        Set keys = redisTemplate.keys("*");
        ValueOperations valueOperations = redisTemplate.opsForValue();

        for (Object key : keys) {
            Object o = valueOperations.get(key);
            System.out.println(o);

        }
    }
}
