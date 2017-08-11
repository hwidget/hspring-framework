package com.ryan.spring.data.mongo;

import com.mongodb.MongoClient;
import com.ryan.spring.data.mongo.repo.entity.PersonEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ScriptOperations;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.script.ExecutableMongoScript;
import org.springframework.data.mongodb.core.script.NamedMongoScript;

import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/12/13 16:03.
 */
public class MongoTestCase {

    private static final Logger LOG = LoggerFactory.getLogger(MongoTestCase.class);

    private MongoTemplate mongoOps;

    @Before
    public void setUp() throws Exception {
        mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new MongoClient(MongoProps.HOST), MongoProps.DB_NAME));
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * Mongo Query
     *
     * @throws Exception
     */
    @Test
    public void testMongoQuery() throws Exception {
        PersonEntity p = new PersonEntity("t-" + System.currentTimeMillis(), "Ryan", 28, new Double[]{120d, 30d}, System.currentTimeMillis());
//        mongoOps.insert(p);

        Query query = new Query(where("_id").is("t-" + System.currentTimeMillis()));
        Update update = new Update();
        update.set("school", "交通大学");
        mongoOps.upsert(query, update, p.getClass());

        query = new Query(where("name").is("Ryan"));
        PersonEntity person = mongoOps.findOne(query, PersonEntity.class);
        LOG.info("{}", person.toString());

        mongoOps.dropCollection("person");
    }

    /**
     * Mongo DB Factory Query
     *
     * @throws Exception
     */
    @Test
    public void testMongoDbFactoryQuery() throws Exception {
        mongoOps.insert(new PersonEntity("Ryan", 28));

        PersonEntity person = mongoOps.findOne(new Query(where("name").is("Ryan")), PersonEntity.class);
        LOG.info("{}", person);

        mongoOps.dropCollection("person");
    }

    /**
     * Mongo Template 增删改查
     *
     * @throws Exception
     */
    @Test
    public void testMongoCrud() throws Exception {
        PersonEntity p = new PersonEntity("Ryan", 27);

        // Insert is used to initially store the object into the database.
        mongoOps.insert(p);
        LOG.info("Insert: " + p);

        // Find
        p = mongoOps.findById(p.getId(), PersonEntity.class);
        LOG.info("Found: " + p);

        // Update
        Query query = query(where("name").is("Ryan"));
        mongoOps.updateFirst(query, update("age", 28), PersonEntity.class);

        p = mongoOps.findOne(query(where("name").is("Ryan")), PersonEntity.class);
        LOG.info("Updated: " + p);

        // Delete
        LOG.info("执行删除开始！");
//        mongoOps.remove(p);
        LOG.info("执行删除结束！");

        // Check that deletion worked
        List<PersonEntity> people = mongoOps.findAll(PersonEntity.class);
        LOG.info("Number of people = : " + people.size());

//        mongoOps.dropCollection(PersonEntity.class);
    }

    /**
     * Mongo 原生语句查询
     *
     * @throws Exception
     */
    @Test
    public void testMongoNativeQuery() throws Exception {
        BasicQuery query = new BasicQuery("{ age : { $lt : 50 } }");
        List<PersonEntity> result = mongoOps.find(query, PersonEntity.class);

        for (PersonEntity person : result) {
            LOG.info("{}", person);
        }
    }

    /**
     * Mongo Script Execute
     *
     * @throws Exception
     */
    @Test
    public void testMongoScript() throws Exception {
        ScriptOperations scriptOps = mongoOps.scriptOps();

        ExecutableMongoScript echoScript = new ExecutableMongoScript("function(x) {  return x + \'234\'; }");

        Object executeResp = scriptOps.execute(echoScript, "directly execute script");
        LOG.info("执行结果: {}", executeResp);

        scriptOps.register(new NamedMongoScript("echo", echoScript));

        final Object echo = scriptOps.call("echo", "execute script via 444name");
        LOG.info("执行结果:{}", echo);
    }


}
