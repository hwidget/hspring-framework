package com.ryan.spring.data.ehcache;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/12/18
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public class SpringDistCache1 {


    public static void main(String[] args) {

        String server1 = "classpath:ehcache/spring-dist-cache-1.xml";

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(server1);

        try {
            applicationContext.start();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
