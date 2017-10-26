package com.ryan.spring.data.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/9/26
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public class MongoMapReduce {

    @Autowired
    private MongoTemplate mongoTemplate;

    private String collectionName;

    /**
     *
     */
    public void mapreduce() {
        this.mongoTemplate.count(Query.query(new TextCriteria()), collectionName);
    }
}
