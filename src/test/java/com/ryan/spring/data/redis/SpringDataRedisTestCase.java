package com.ryan.spring.data.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
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

    private String channel = "1";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOps;

    @Resource(name = "redisTemplate")
    private ValueOperations valueOps;

//    @Resource(name = "redisTemplate")
//    private StringRedisTemplate stringRedisTemplate;

    /**
     * @throws Exception
     */
    @Test
    public void testList() throws Exception {
        Set<String> keys = listOps.getOperations().keys("*");

    }

    @Test
    public void testStrLength() throws Exception {
        LOG.info("{}", "测试发布消息!".length());

    }

    /**
     * 发布消息
     *
     * @throws Exception
     */
    @Test
    public void testSending() throws Exception {

        for (int i = 0; i < 100; i++) {
            LOG.info("发布第：{}条消息。", i);
            redisTemplate.convertAndSend(channel, "测试发布消息!");
            Thread.sleep(3 * 1000);
        }

    }

    /**
     * Redis 事务操作
     *
     * @throws Exception
     */
    @Test
    public void testRedisTransaction() throws Exception {
        //execute a transaction
        List<Object> txResults = redisTemplate.execute(new SessionCallback<List<Object>>() {
            public List<Object> execute(RedisOperations operations) throws DataAccessException {
                operations.multi();
                operations.opsForSet().add("key", "value1");

                // This will contain the results of all ops in the transaction
                return operations.exec();
            }
        });

        System.out.println("Number of items added to set: " + txResults.get(0));

    }

    /**
     * @throws Exception
     */
    @Test
    public void testRedisPiplined() throws Exception {
        redisTemplate.executePipelined(new SessionCallback<String>() {
            public <K, V> String execute(RedisOperations<K, V> operations) throws DataAccessException {


                return null;
            }
        });

    }

    @Test
    public void testRedisLua() throws Exception {

        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<Boolean>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("META-INF/scripts/checkandset.lua")));
        redisScript.setResultType(Boolean.class);


        String expectedValue = "test";
        String newValue = "";

        redisTemplate.execute(redisScript, Collections.singletonList("key"), expectedValue, newValue);

    }
}
