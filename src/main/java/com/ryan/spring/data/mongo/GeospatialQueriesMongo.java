package com.ryan.spring.data.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/11/3
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public class GeospatialQueriesMongo extends AbstractMongo {

    private static final Logger LOG = LoggerFactory.getLogger(GeospatialQueriesMongo.class);


    /**
     * 创建二维坐标
     */
    public void create2dIndex(){

        DBCollection collection = getCollection();

        BasicDBObject basicDBObject = new BasicDBObject();
        collection.createIndex(basicDBObject, "2d");

    }


    /**
     * 创建二维坐标
     */
    public void create2dSphereIndex(){

        DBCollection collection = getCollection();

        BasicDBObject basicDBObject = new BasicDBObject();
        collection.createIndex(basicDBObject, "2dsphere");

    }


    /**
     * 创建二维坐标
     */
    public void create3dSphereIndex(){

        DBCollection collection = getCollection();

        BasicDBObject basicDBObject = new BasicDBObject();
        collection.createIndex(basicDBObject, "2dsphere");

    }


    /**
     *
     */
    public void geo2DSphere(){

        // aggregate: geoNear
        double[] currentLoc = new double[] {37.3701306068, 101.6454770379d};

        BasicDBObject geoNearFields = new BasicDBObject();
        geoNearFields.put("near", currentLoc);
        geoNearFields.put("distanceField", "dis");

        BasicDBObject geoNear = new BasicDBObject("$geoNear", geoNearFields);

        DBCollection collection = getCollection();
        DBCursor dbCursor = collection.find(geoNear);

        printCusor(dbCursor);
    }


    /**
     *
     */
    public void geo3DSpahere(){

    }



    /**
     *
     */
    @Override
    public void exec() {

    }

    public static void main(String[] args) {

        GeospatialQueriesMongo geospatialQueriesMongo = new GeospatialQueriesMongo();
        geospatialQueriesMongo.exec();
    }
}
