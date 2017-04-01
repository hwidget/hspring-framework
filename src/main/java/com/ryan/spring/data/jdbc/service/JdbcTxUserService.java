package com.ryan.spring.data.jdbc.service;

import java.sql.SQLException;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/4/1
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public interface JdbcTxUserService {

    /**
     *
     * @return
     */
    public boolean txTest();

    /**
     *
     * @return
     */
    public boolean disTxTest();
}
