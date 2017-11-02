package com.ryan.spring.data.mongo;

import com.mongodb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/11/2
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public class MongoGeneralOpertions extends AbstractMongo {

    private static final Logger LOG = LoggerFactory.getLogger(MongoGeneralOpertions.class);


    /**
     * 新增数据
     */
    public void insertOperation() {
        DBCollection collection = getCollection();

        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("age", 23);
        basicDBObject.put("name", "Ryan1");
        basicDBObject.put("sex", '女');
        basicDBObject.put("isDel", true);


        WriteResult writeResult = collection.insert(basicDBObject);

        int writeResultN = writeResult.getN();
        LOG.info("writeResultN : {}", writeResultN);

        Object upsertedId = writeResult.getUpsertedId();
        LOG.info("upsertedId : {}", upsertedId);

    }

    /**
     *
     */
    public void bulkWriteOperation() {

        DBCollection collection = getCollection();

        List<DBObject> args = new ArrayList<DBObject>();
        args.add(new BasicDBObject());

        collection.insert(args);
    }


    /**
     * 查询
     */
    public void findOperation() {

        // 1.
        DBCollection collection = getCollection();
        DBObject one = collection.findOne();
        LOG.info("findOne : {}", one);

        // 2.
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("age", 23);
        DBCursor dbObjects = collection.find(basicDBObject);

        while (dbObjects.hasNext()) {
            DBObject next = dbObjects.next();
            LOG.info("当前查询到: {}", next);
        }


    }


    /**
     * 更新
     */
    public void updateAndUpsertOperation() {
        DBCollection collection = getCollection();

        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("age", 22);

        BasicDBObject newObj = new BasicDBObject();
        newObj.put("isFlag", false);
        newObj.put("isDel", true);
        newObj.put("score", 23);

        collection.update(basicDBObject, newObj, true, false);

    }


    /**
     * 删除操作
     */
    public void delOperation() {
        DBCollection collection = getCollection();

        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("sex", '0');

        collection.remove(basicDBObject);

    }


    /**
     * 聚合操作
     */
    public void aggreOperation() {
        DBCollection collection = getCollection();

        AggregationOptions builder = AggregationOptions.builder()
                .allowDiskUse(true)
                .outputMode(AggregationOptions.OutputMode.INLINE)
                .build();


        // 查询数据
        List<DBObject> pipeline = new ArrayList<DBObject>();

        // match
        DBObject query = new BasicDBObject();
        query.put("isDel", false);
        DBObject match = new BasicDBObject("$match", query);
        pipeline.add(match);

        // 2. group by
        DBObject group = new BasicDBObject("$group", new BasicDBObject("_id", "$sex").append("total", new BasicDBObject("$sum", "$score")));
//        DBObject group = new BasicDBObject("$group", new BasicDBObject("_id", "$sex").append("count", new BasicDBObject("$sum", 1)));

        pipeline.add(group);

        // 3. order by
        DBObject sort = new BasicDBObject("$sort", new BasicDBObject("name", 1));
        pipeline.add(sort);

        // 4. limit
        DBObject limit = new BasicDBObject("$limit", 100);
        pipeline.add(limit);

        Cursor cursor = collection.aggregate(pipeline, builder);

        printCusor(cursor);

    }


    /**
     * mongo map reduce 操作
     */
    public void mongoMapReduce() {

        DBCollection collection = getCollection("data720", "test_ax");


        String map = "function (){" +
                "   if(this.serviceTypeUrn % 3 == 0){" +
                "       emit('A', {count:1});" +
                "   } else if (this.serviceTypeUrn % 3 == 1){" +
                "       emit('B', {count:1});" +
                "   } else if(this.serviceTypeUrn % 3 == 2){" +
                "       emit('C',{count:1});" +
                "   }" +
                "}";

        String reduce = "function (key,values){ " +
                "   var cnt=0;" +
                "   values.forEach(function(val){ " +
                "       cnt += val.count;" +
                "   });" +
                "   return {\"count\":cnt};" +
                "}";

        MapReduceOutput output = collection.mapReduce(map, reduce, "output", null);

        printIterator(output.results());

    }

    /**
     * distinct 统计数据
     */
    public void distinct() {
        DBCollection collection = getCollection();

        List age = collection.distinct("age");

        for (Object o : age) {
            LOG.info("{}", o);
        }
    }


    /**
     *
     */
    @Override
    public void exec() {
//        insertOperation();

//        findOperation();

//        updateAndUpsertOperation();

//        delOperation();

        /**
         *
         */
//        aggreOperation();


        /**
         *
         */
//        mongoMapReduce();


        /**
         * 去重查询
         */
        distinct();

    }


    public static void main(String[] args) {

        MongoGeneralOpertions mongoGeneralOpertions = new MongoGeneralOpertions();


        mongoGeneralOpertions.exec();
    }

}
