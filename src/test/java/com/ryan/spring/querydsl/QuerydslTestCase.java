package com.ryan.spring.querydsl;

import com.querydsl.codegen.BeanSerializer;
import com.querydsl.sql.Configuration;
import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;
import com.querydsl.sql.codegen.MetaDataExporter;
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
import java.io.File;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2016/12/30 14:23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:data/data-source.xml"})
public class QuerydslTestCase {
    private static final Logger LOG = LoggerFactory.getLogger(QuerydslTestCase.class);

    @Autowired
    private DataSource dataSource;

    /**
     * 导出实体类
     *
     * @throws Exception
     */
    @Test
    public void testCodeGeneration() throws Exception {
        MetaDataExporter exporter = new MetaDataExporter();
        exporter.setPackageName("com.ryan.spring.querydsl.schema");
        exporter.setTargetFolder(new File("src/main/java/"));
        exporter.setBeanSerializer(new BeanSerializer());

        exporter.export(dataSource.getConnection().getMetaData());
    }
}
