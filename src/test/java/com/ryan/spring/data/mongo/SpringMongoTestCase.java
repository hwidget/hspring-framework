package com.ryan.spring.data.mongo;

import com.mongodb.MapReduceCommand;
import com.ryan.spring.data.mongo.repo.PersonRepo;
import com.ryan.spring.data.mongo.repo.entity.PersonEntity;
import com.sun.beans.decoder.ValueObject;
import com.sun.org.apache.xpath.internal.objects.XObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.mapreduce.MapReduceOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;

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
    private MongoTemplate mongoTemplate;

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
     *
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

    /**
     * MongoTemplate Some methods
     *
     * @throws Exception
     */
    @Test
    public void testFinds() throws Exception {
        final List<PersonEntity> allPerson = this.mongoTemplate.findAll(PersonEntity.class);

    }

    /**
     * 打印列表中的信息
     *
     * @param objects
     */
    public void printLists(List objects) {
        for (Object object : objects) {
            LOG.info("{}", object);
        }
    }

    /**
     * Mongo Geo
     *
     * @throws Exception
     */
    @Test
    public void testMongoGeo() throws Exception {
        Circle circle1 = new Circle(-73.99171, 40.738868, 0.01);

        List<PersonEntity> person1 = this.mongoTemplate.find(new Query(where("location").within(circle1)), PersonEntity.class);
        printLists(person1);

        /**
         * 按照中心点查询，半径为: 0.003712240453784
         */
        Circle circle2 = new Circle(-73.99171, 40.738868, 0.003712240453784);
        List<PersonEntity> person2 = mongoTemplate.find(new Query(where("location").withinSphere(circle2)), PersonEntity.class);
        printLists(person2);


        //lower-left then upper-right
        Box box = new Box(new Point(-73.99756, 40.73083), new Point(-73.988135, 40.741404));
        List<PersonEntity> person3 = mongoTemplate.find(new Query(where("location").within(box)), PersonEntity.class);
        printLists(person3);

        /**
         * To find person3 near a Point, the following queries can be used
         */
        Point point1 = new Point(-73.99171, 40.738868);
        List<PersonEntity> person4 = mongoTemplate.find(new Query(where("location").near(point1).maxDistance(0.01)), PersonEntity.class);
        printLists(person4);

        Point point2 = new Point(-73.99171, 40.738868);
        List<PersonEntity> person5 = mongoTemplate.find(new Query(where("location").near(point2).minDistance(0.01).maxDistance(100)), PersonEntity.class);
        printLists(person5);

        Point point = new Point(-73.99171, 40.738868);
        List<PersonEntity> person6 = mongoTemplate.find(new Query(where("location").nearSphere(point).maxDistance(0.003712240453784)), PersonEntity.class);
        printLists(person6);

        /**
         * Mongo 地理位置信息支持
         */
        Point location = new Point(-73.99171, 40.738868);
        NearQuery query = NearQuery.near(location).maxDistance(new Distance(10, Metrics.MILES));
        GeoResults<Double> geoResults = mongoTemplate.geoNear(query, Double.class);


        final GeoJsonPoint geoJsonPoint = new GeoJsonPoint(-73.99171, 40.738868);

        /**
         * 多边形
         */
//        final GeoJsonPolygon geoJsonPolygon = new GeoJsonPolygon();

    }

    /**
     * @throws Exception
     */
    @Test
    public void testFullTextIndex() throws Exception {
        Query query = TextQuery.queryText(new TextCriteria().matchingAny("coffee", "cake")).sortByScore();
        List<Document> page = mongoTemplate.find(query, Document.class);


        TextQuery.queryText(new TextCriteria().matching("coffee").matching("-cake"));

        TextQuery.queryText(new TextCriteria().matching("coffee").notMatching("cake"));

    }

    /**
     * Mongo MapReduce
     *
     * @throws Exception
     */
    @Test
    public void testMapReduce() throws Exception {
        MapReduceResults<ValueObject> results = mongoTemplate.mapReduce("jmr1", "classpath:data/mongo/map.js", "classpath:data/mongo/reduce.js", ValueObject.class);
        for (ValueObject valueObject : results) {
            LOG.info("{}", valueObject);
        }

        MapReduceResults<ValueObject> results2 = mongoTemplate.mapReduce("jmr1", "classpath:data/mongo/map.js", "classpath:data/mongo/reduce.js",
                new MapReduceOptions().outputCollection("jmr1_out"), ValueObject.class);

        for (ValueObject valueObject : results2) {
            LOG.info("{}", valueObject);
        }

        Query query = new Query(where("x").ne(new String[]{"a", "b"}));
        MapReduceResults<ValueObject> results3 = mongoTemplate.mapReduce(query, "jmr1", "classpath:data/mongo/map.js", "classpath:data/mongo/reduce.js", options().outputCollection("jmr1_out"), ValueObject.class);
        for (ValueObject valueObject : results3) {
            LOG.info("{}", valueObject);
        }

    }

    /**
     * @throws Exception
     */
    @Test
    public void testGroup() throws Exception {

        GroupByResults<XObject> results = mongoTemplate.group("group_test_collection", GroupBy.key("x").initialDocument("{ count: 0 }").reduceFunction("function(doc, prev) { prev.count += 1}"), XObject.class);

    }

    /**
     * Aggregation
     * @throws Exception
     */
    @Test
    public void testAggregation() throws Exception {

        Aggregation agg = newAggregation(/* .... */);
        AggregationResults<MapReduceCommand.OutputType> results = mongoTemplate.aggregate(agg, "INPUT_COLLECTION_NAME", MapReduceCommand.OutputType.class);
        List<MapReduceCommand.OutputType> mappedResult = results.getMappedResults();


    }
}
