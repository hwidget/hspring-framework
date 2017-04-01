package com.ryan.spring.data.jdbc;

import com.ryan.spring.data.jdbc.service.JdbcTxUserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/4/1
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:data/spring-data-jta-jdbctemplate.xml"})
public class JdbcJtaTestCase {

    private static final Logger LOG = LoggerFactory.getLogger(JdbcJtaTestCase.class);


    //    @Autowired
    private JdbcTxUserService jdbcTxUserService;


    /**
     * 使用 RuntimeException 可以回滚所有Service 里面的方法。
     *
     * @throws Exception
     */
    @Test
    @Transactional(rollbackFor = Exception.class)
    public void testJtaRollback() throws Exception {
        LOG.info("测试日志打印!");


        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:data/spring-data-jta-jdbctemplate.xml");
        jdbcTxUserService = applicationContext.getBean(JdbcTxUserService.class);

        boolean success = jdbcTxUserService.disTxTest();

        LOG.info("执行结果: {}", success);

        while (true) {
            if (applicationContext.isRunning()) {
                break;
            }
        }

    }
}
