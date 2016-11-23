package com.ryan.spring.data.redis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/23 17:43.
 */
public class RedisPubsubTestCase {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("data/spring-data-redis.xml");
        ;
        while (true) { //这里是一个死循环,目的就是让进程不退出,用于接收发布的消息
            try {
                System.out.println("current time: " + new Date());

                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
