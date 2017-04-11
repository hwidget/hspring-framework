package com.ryan.spring.data.jdbc.service.impl;

import com.ryan.spring.data.jdbc.service.JdbcTxUserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/4/1
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */

public class JdbcTxUserServiceImpl implements JdbcTxUserService {

    private JdbcTemplate jdbcTemplate;

    private JdbcTemplate jdbcTemplate2;

    public JdbcTxUserServiceImpl() {
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate2(JdbcTemplate jdbcTemplate2) {
        this.jdbcTemplate2 = jdbcTemplate2;
    }


    /**
     * 单库事务测试
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean txTest() {
        int u1 = jdbcTemplate.update("insert b_users set nikename = ?", new Object[]{"测试nikename"});
        int u2 = jdbcTemplate.update("insert into b_categorys set category_name = ? ", new Object[]{"文学哲理"});

        if (u1 > 0 || u2 > 0) {
            /**
             * 必须使用 RuntimeException 可以回滚
             */
            throw new RuntimeException("我看看它是否回滚了。");
        }
        return true;
    }


    /**
     * 分布式事务测试
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean disTxTest() {

        String nikeName = "123123";

        int u1 = jdbcTemplate.update("insert b_users set nikename = ?", new Object[]{nikeName});
        int u2 = jdbcTemplate.update("insert into b_categorys set category_name = ? ", new Object[]{"文学哲理"});

        int u3 = jdbcTemplate2.update("insert into lwb_test set name='test'");

        if (u2 > 0 || u3 > 0) {
            /**
             * 必须使用 RuntimeException 可以回滚
             */
            throw new RuntimeException("我看看它是否回滚了。");
        }

        return true;
    }
}
