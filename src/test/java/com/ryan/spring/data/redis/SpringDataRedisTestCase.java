package com.ryan.spring.data.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Set;

/**
 *
 * --------------------Key Type Operations------------------
 * ValueOperations                       Redis string (or value) operations
 * ListOperations                         Redis list operations
 * SetOperations                          Redis set operations
 * ZSetOperations                         Redis zset (or sorted set) operations
 * HashOperations                         Redis hash operations
 * HyperLogLogOperations                  Redis HyperLogLog operations like (pfadd, pfcount,…​)
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * -------------------Key Bound Operations----------------------------
 * BoundValueOperations                  Redis string (or value) key bound operations
 * BoundListOperations                    Redis list key bound operations
 * BoundSetOperations                     Redis set key bound operations
 * BoundZSetOperations                    Redis zset (or sorted set) key bound operations
 * BoundHashOperations                    Redis hash key bound operations
 *
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/21 16:46.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:data/spring-data-redis.xml"})
public class SpringDataRedisTestCase {
    private static final Logger LOG = LoggerFactory.getLogger(SpringDataRedisTestCase.class);

    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOps;

    @Resource(name="redisTemplate")
    private ValueOperations valueOps;

    @Resource(name="redisTemplate")
    private StringRedisTemplate stringRedisTemplate;

    /**
     * @throws Exception
     */
    @Test
    public void testList() throws Exception {
        Set<String> keys = listOps.getOperations().keys("*");


    }
}
