package com.ryan.spring.data.mongo.repo;

import com.ryan.spring.data.mongo.repo.entity.PersonEntity;
import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/12/15 13:46.
 */
public interface GeoStoreRepo extends MongoRepository<PersonEntity, String> {

    /**
     * 多边形查询
     *
     * @param polygon
     * @return
     */
    public List<PersonEntity> findByLocationWithin(Polygon polygon);
}
