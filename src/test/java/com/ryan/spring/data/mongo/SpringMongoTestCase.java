package com.ryan.spring.data.mongo;

import com.ryan.spring.data.mongo.repo.PersonRepo;
import com.ryan.spring.data.mongo.repo.entity.PersonEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/12/13 16:03.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:data/spring-data-mongo.xml"})
public class SpringMongoTestCase {

    private static final Logger LOG = LoggerFactory.getLogger(SpringMongoTestCase.class);

    @Autowired
    private PersonRepo repo;


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * 添加数据
     * @throws Exception
     */
    @Test
    public void testAddData() throws Exception {
        final PersonEntity personEntity = new PersonEntity("test", 22);

        final PersonEntity save = this.repo.save(personEntity);

        LOG.info("保存实体的ID 为: {}", save.getId());

    }

    /**
     * FindAll
     *
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {
        final Iterable<PersonEntity> persons = repo.findAll();
        for (PersonEntity person : persons) {
            LOG.info("{}, {}, {}", person.getId(), person.getName(), person.getAge());
        }

    }
}
