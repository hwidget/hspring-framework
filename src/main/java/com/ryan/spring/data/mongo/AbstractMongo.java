package com.ryan.spring.data.mongo;

import com.mongodb.*;
import org.bson.BSONObject;

import java.net.UnknownHostException;
import java.util.Iterator;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/11/2
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public abstract class AbstractMongo {

    protected String db = "test";
    protected String collectionName = "test";
    protected String host = "192.168.1.115";
    protected int port = 8888;

    protected Mongo mongoClient;


    public AbstractMongo() {
        this("test");
    }

    public AbstractMongo(String collectionName) {
        try {
            this.collectionName = collectionName;
            this.mongoClient = new MongoClient(host, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return
     */
    public DB getDB() {
        return this.mongoClient.getDB(this.db);
    }

    /**
     * 获取 DB
     *
     * @return
     */
    public DB getDB(String argsDb) {
        return this.mongoClient.getDB(argsDb);
    }


    public DBCollection getCollection(String collectionName) {
        return getDB().getCollection(collectionName);
    }


    /**
     * @return
     */
    public DBCollection getCollection() {
        return getCollection(collectionName);
    }


    public DBCollection getCollection(String db, String collectionName) {
        return getDB(db).getCollection(collectionName);
    }

    /**
     * 打印结果集合
     *
     * @param cursor
     */
    protected void printCusor(Cursor cursor) {
        while (cursor.hasNext()) {
            DBObject dbObject = cursor.next();

            System.out.println(dbObject);
        }
    }

    /**
     *
     * @param iterable
     */
    protected void printIterator(Iterable<DBObject> iterable){
        Iterator<DBObject> iterator = iterable.iterator();

        while(iterator.hasNext()){
            DBObject dbObject = iterator.next();

            System.out.println(dbObject);

        }
    }

    /**
     *
     */
    public abstract void exec();

}
