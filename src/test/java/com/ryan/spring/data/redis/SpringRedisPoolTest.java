package com.ryan.spring.data.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Random;
import java.util.UUID;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/10/26
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 *              这个是 Spring Redis 重要的测试。
 */
public class SpringRedisPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-redis-test.xml");
        final RedisTemplate redisTemplate = applicationContext.getBean(RedisTemplate.class);

        final Random random = new Random();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        final int i = random.nextInt(10);
                        String key = UUID.randomUUID().toString();
                        if (i % 2 == 0) {
                            redisTemplate.opsForValue().set(key, key);
                        } else if (i % 1 == 0) {
                            redisTemplate.opsForValue().get(key);
                        }
                        System.out.println(Thread.currentThread().getId() + ":" + key);
                        try {
                            Thread.sleep(i * 10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        Thread.sleep(100000);
    }

}
