package com.ryan.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/11/1
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */


public class TempAppTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("temp-app-redis.xml");

        applicationContext.start();

        while (applicationContext.isRunning()) {

        }
    }
}

