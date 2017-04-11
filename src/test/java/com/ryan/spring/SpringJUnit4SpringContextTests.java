package com.ryan.spring;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/3/16
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription: Spring 整体测试框架
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-*.xml"})
public abstract class SpringJUnit4SpringContextTests extends AbstractTransactionalJUnit4SpringContextTests {

    protected static final Logger LOG = LoggerFactory.getLogger(SpringJUnit4SpringContextTests.class);

}
