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
public class SpringDistCache2 {


    public static void main(String[] args) {
        String server2 = "classpath:ehcache/spring-dist-cache-2.xml";

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(server2);


        try {
            applicationContext.start();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {


        }


    }
}
