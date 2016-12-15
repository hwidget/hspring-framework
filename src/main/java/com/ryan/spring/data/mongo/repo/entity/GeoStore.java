package com.ryan.spring.data.mongo.repo.entity;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/12/15 13:44.
 */
@Document(collection = "geostore")
public class GeoStore {

    private String id;

    private GeoJsonPoint location;

    public GeoStore() {
    }

    public GeoStore(String id, GeoJsonPoint location) {
        this.id = id;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GeoJsonPoint getLocation() {
        return location;
    }

    public void setLocation(GeoJsonPoint location) {
        this.location = location;
    }
}
