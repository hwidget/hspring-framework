package com.ryan.spring.data.mongo;

import com.ryan.spring.data.mongo.repo.entity.PersonEntity;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/12/15 14:11.
 */
public class PersonConverter implements Converter<Document, PersonEntity> {

    private static final Logger LOG = LoggerFactory.getLogger(PersonConverter.class);



    @Override
    public PersonEntity convert(Document document) {
        PersonEntity p = new PersonEntity((String) document.get("_id"), (String) document.get("name"));
        p.setAge((Integer) document.get("age"));
        return p;
    }
}
