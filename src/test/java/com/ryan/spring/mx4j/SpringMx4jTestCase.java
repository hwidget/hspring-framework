package com.ryan.spring.mx4j;

import mx4j.tools.adaptor.http.HttpAdaptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/8/11
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public class SpringMx4jTestCase {

    public static void main(String [] args) throws IOException {

            ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:mx4j/spring-mx4j.xml");

            HttpAdaptor httpAdaptor = (HttpAdaptor) ctx.getBean("httpAdaptor");

            httpAdaptor.start();

        /**
         * 启动成功后，可以通过浏览http://192.168.102.29:9988，可以看到我们注册的MBean，并对其进行管理和监控
         */

    }

}
