package com.ryan.spring.querydsl;

import com.querydsl.sql.Configuration;
import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.File;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2016/12/30 14:23.
 */
public class QuerydslTestCase {
    private static final Logger LOG = LoggerFactory.getLogger(QuerydslTestCase.class);

    private SQLQueryFactory queryFactory = null;
    private Configuration configuration = null;

    private DataSource dataSource = null;


    @Before
    public void setUp() throws Exception {
        // SQL-dialect
        SQLTemplates dialect = new MySQLTemplates();
        configuration = new Configuration(dialect);

        queryFactory = new SQLQueryFactory(configuration, dataSource);
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * 测试查询
     *
     * @throws Exception
     */
    @Test
    public void testQueryDsl() throws Exception {


    }
}
