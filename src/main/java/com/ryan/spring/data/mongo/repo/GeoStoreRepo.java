package com.ryan.spring.data.mongo.repo;

import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/12/15 13:46.
 */
public interface GeoStoreRepo extends MongoRepository<GeoStoreRepo, String> {

    /**
     * 多边形查询
     *
     * @param polygon
     * @return
     */
    public List<GeoStoreRepo> findByLocationWithin(Polygon polygon);
}
