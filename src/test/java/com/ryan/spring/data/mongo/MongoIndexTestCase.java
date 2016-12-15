package com.ryan.spring.data.mongo;

import com.ryan.spring.data.mongo.repo.entity.PersonEntity;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexInfo;

import java.util.List;

/**
 * MongoDB 索引生成
 *
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/12/15 14:27.
 */
public class MongoIndexTestCase {

    private static final Logger LOG = LoggerFactory.getLogger(MongoIndexTestCase.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 生成索引
     *
     * @throws Exception
     */
    @Test
    public void testEnsureIndex() throws Exception {
        mongoTemplate.indexOps(PersonEntity.class).ensureIndex(new Index().on("name", Sort.Direction.ASC));

        mongoTemplate.indexOps(PersonEntity.class).ensureIndex(new Index().on("age", Sort.Direction.DESC).unique(Index.Duplicates.DROP));
        List<IndexInfo> indexInfoList = mongoTemplate.indexOps(PersonEntity.class).getIndexInfo();

        mongoTemplate.indexOps(PersonEntity.class).ensureIndex(new GeospatialIndex("location"));

    }
}
