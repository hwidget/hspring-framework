package com.ryan.spring.session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/7/13 17:17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-session.xml"})
public class SpringSessionTestCase {

    @Test
    public void testSpringSessionTable() throws Exception {
        System.out.println("App");

    }
}
