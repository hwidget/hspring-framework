package com.ryan.spring.querydsl;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.sql.*;
import com.querydsl.sql.dml.DefaultMapper;
import com.ryan.spring.BaseQuery;
import com.ryan.spring.querydsl.schema.QBBlogs;
import com.ryan.spring.querydsl.schema.QBComments;
import com.ryan.spring.querydsl.schema.QBUsers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2016/12/30 14:23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:data/data-source.xml"})
public class ExecQueryTestCase extends BaseQuery {
    private static final Logger LOG = LoggerFactory.getLogger(ExecQueryTestCase.class);

    private SQLQueryFactory queryFactory;

    private Configuration configuration;

    @Autowired
    private DataSource dataSource;


    @Before
    public void setUp() throws Exception {
        // SQL-dialect
        SQLTemplates dialect = new MySQLTemplates();
        MySQLTemplates.builder()
                .printSchema() // to include the schema in the output
                .quote()       // to quote names
                .newLineToSingleSpace() // to replace new lines with single space in the output
                .escape(' ')    // to set the escape char
                .build();      // to get the customized SQLTemplates instance

        configuration = new Configuration(dialect);

        queryFactory = new SQLQueryFactory(configuration, dataSource);
    }

    @After
    public void tearDown() throws Exception {

    }


    /**
     * 根据 where 条件查询
     *
     * @throws Exception
     */
    @Test
    public void testQuery() throws Exception {
        QBUsers user = new QBUsers("user");

        List<String> lastNames = queryFactory.select(user.nikename).from(user)
                .where(user.nikename.isNotEmpty())
                .fetch();

        print(lastNames);


    }

    /**
     * Inner Join Query
     *
     * @throws Exception
     */
    @Test
    public void testInnerJoin() throws Exception {
        /**
         * Join
         */
        QBComments bComments = QBComments.bComments;
        QBBlogs bBlogs = QBBlogs.bBlogs;
        List<Tuple> fetch = queryFactory.select(bComments.nikename, bComments.likes, bBlogs.blogTitle)
                .from(bComments)
                .innerJoin(bComments.blogsCommentsPk, bBlogs)
                .fetch();

        print(fetch);
    }

    /**
     * Left Join Query
     *
     * @throws Exception
     */
    @Test
    public void testLeftJoin() throws Exception {
        /**
         * Join
         */
        QBComments bComments = QBComments.bComments;
        QBBlogs bBlogs = QBBlogs.bBlogs;
        List<Tuple> fetch = queryFactory.select(bComments.nikename, bComments.likes, bBlogs.blogTitle)
                .from(bComments)
                .leftJoin(bComments.blogsCommentsPk, bBlogs)
                /**
                 *排序
                 */
                .orderBy(bComments.likes.desc(), bComments.nikename.asc())
                .fetch();

        print(fetch);

    }

    /**
     * @throws Exception
     */
    @Test
    public void testGoupBy() throws Exception {
        QBUsers users = QBUsers.bUsers;
        List<Integer> fetch = queryFactory.select(users.age)
                .from(users)
                .groupBy(users.age)
                .fetch();

        print(fetch);
    }

    /**
     * @throws Exception
     */
    @Test
    public void testSelectLiterals() throws Exception {
        queryFactory.select(Expressions.constant(1), Expressions.constant("abc"));

    }

    /**
     * 执行插入操作
     *
     * @throws Exception
     */
    @Test
    public void testInsert() throws Exception {
        QBUsers users = QBUsers.bUsers;

        long execResult = queryFactory.insert(users).columns(users.userId, users.nikename).values(5, "Hello").execute();

        LOG.info("{}", execResult);


        queryFactory.insert(users).values(4, "Hello").execute();


        /**
         * With subquery
         */
        queryFactory.insert(users).columns(users.userId, users.nikename).select(SQLExpressions.select(users.userId.add(1), users.nikename).from(users)).execute();


        /**
         * With subquery, without columns
         */
        queryFactory.insert(users).select(SQLExpressions.select(users.userId.add(10), users.nikename).from(users)).execute();

        queryFactory.insert(users).populate(users, DefaultMapper.WITH_NULL_BINDINGS).execute();
    }

    @Test
    public void testUpdate() throws Exception {
        /**
         * With where
         */
        QBUsers users = QBUsers.bUsers;
        queryFactory.update(users)
                .where(users.nikename.eq("XXX"))
                .set(users.nikename, "S")
                .execute();

        /**
         * Without where
         */
        queryFactory.update(users)
                .set(users.nikename, "S")
                .execute();

        /**
         * Using bean population
         */
        queryFactory.update(users)
                .populate(users)
                .execute();

    }

    /**
     * Delete
     *
     * @throws Exception
     */
    @Test
    public void testDelete() throws Exception {

        QBUsers users = QBUsers.bUsers;

        queryFactory.delete(users).where(users.nikename.eq("XXX")).execute();


        /**
         * Without where
         */
        queryFactory.delete(users).execute();

    }
}
