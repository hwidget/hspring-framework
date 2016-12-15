package com.ryan.spring.data.mongo.repo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/12/13 16:01.
 */
@Document(collection="ryan")
public class PersonEntity {

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("age")
    private int age;

    public PersonEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

}
