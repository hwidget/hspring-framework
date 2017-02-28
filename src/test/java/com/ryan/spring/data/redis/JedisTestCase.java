package com.ryan.spring.data.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2017/2/28 17:38.
 */
public class JedisTestCase {

    private static final Logger LOG = LoggerFactory.getLogger(JedisTestCase.class);

    private Jedis jedis;

    @Before
    public void setUp() throws Exception {
        jedis = new Jedis("127.0.0.1", 9999, 50 * 1000, 5 * 1000);
    }

    @After
    public void tearDown() throws Exception {
        if (null != jedis) {
            jedis.close();
        }

    }

    @Test
    public void testKeys() throws Exception {
        Set<byte[]> keys = jedis.keys("*".getBytes());

        System.err.println(keys);
    }
}
