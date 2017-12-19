package com.ryan.spring.data.jdbc;

import com.ryan.spring.data.jdbc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/4/1
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:data/spring-data-tx-test.xml"})
public class JdbcTxTestCase {

    private static final Logger LOG = LoggerFactory.getLogger(JdbcTxTestCase.class);


    @Autowired
    private UserService userService;


    /**
     * 使用 RuntimeException 可以回滚所有Service 里面的方法。
     *
     * @throws Exception
     */
    @Test
    public void testRollback() throws Exception {
        LOG.info("测试日志打印!");

        userService.addUser();

        LOG.info("执行结果: true");

    }
}
