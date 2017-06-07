package com.ryan.spring.data.jdbc.service.impl;

import com.ryan.spring.data.jdbc.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/6/6
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 添加用户
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public void addUser() {
        this.jdbcTemplate.update("insert into r_user(login_name, login_pass) values(\"test\", \"testtest\");");
        this.jdbcTemplate.update("insert into r_user(login_name, login_pass) values(\"test11\", \"testtest11\");");

        System.out.println(1 / 0);
    }
}
