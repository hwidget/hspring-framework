package com.ryan.spring.data.mongo;

import com.mongodb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/10/30
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public class MongoCappedCollection {

    private static final Logger LOG = LoggerFactory.getLogger(MongoCappedCollection.class);

    private String db = "test";
    private String cappedCollect = "cappedCollect";

    private String host = "192.168.1.115";
    private int port = 8888;

    private Mongo mongoClient;

    public MongoCappedCollection() {
        try {
            this.mongoClient = new MongoClient(host, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    /**
     * 创建固定集合
     */
    public void createCappedCollect(){
        DB db = this.mongoClient.getDB(this.db);
        BasicDBObject dbObject = new BasicDBObject();
        dbObject.append("size", 100000);
        dbObject.append("capped", true);
        dbObject.append("max", 5000);

        db.createCollection(cappedCollect, dbObject);
    }

    /**
     * 批量插入
     */
    public void multiInsert(){
        DB db = this.mongoClient.getDB(this.db);
        DBCollection collection = db.getCollection(cappedCollect);

        boolean capped = collection.isCapped();
        LOG.info("Collection is capped : {}", capped);


        BasicDBObject basicDBObject = null;
        for (int i = 0; i < 10000000; i++) {
            basicDBObject = new BasicDBObject();
            basicDBObject.put("_id", i);
            basicDBObject.put("uname", "Ryan-" + i);
            basicDBObject.put("age", i);

            collection.insert(basicDBObject);
        }
    }



    public static void main(String[] args) {

        MongoCappedCollection mongoCappedCollection = new MongoCappedCollection();

//        mongoCappedCollection.createCappedCollect();

        mongoCappedCollection.multiInsert();
    }


}
