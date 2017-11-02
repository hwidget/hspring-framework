package com.ryan.spring.data.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/11/2
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public class TextSearchMongo extends AbstractMongo {

    private static final Logger LOG = LoggerFactory.getLogger(TextSearchMongo.class);

    public TextSearchMongo() {

    }

    /**
     * 创建索引
     */
    public void createIndex(){

//        db.stores.createIndex( { name: "text", description: "text" } )

        DBCollection collection = getCollection();

        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("name", "text");

        collection.createIndex(basicDBObject);


    }


    /**
     *
     */
    public void textSearch(){

    }


    /**
     *
     */
    @Override
    public void exec() {
        textSearch();
    }

    public static void main(String[] args) {

        TextSearchMongo textSearchMongo = new TextSearchMongo();
        textSearchMongo.exec();
    }
}
