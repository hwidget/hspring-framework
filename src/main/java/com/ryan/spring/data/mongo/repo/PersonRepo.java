package com.ryan.spring.data.mongo.repo;

import com.ryan.spring.data.mongo.repo.entity.PersonEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/12/15 11:40.
 */
public interface PersonRepo extends MongoRepository<PersonEntity, String> {

}
