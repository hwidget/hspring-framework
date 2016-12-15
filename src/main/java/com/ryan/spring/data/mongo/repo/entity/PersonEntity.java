package com.ryan.spring.data.mongo.repo.entity;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Arrays;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/12/13 16:01.
 */
@Document(collection="ryan")
public class PersonEntity implements Serializable {

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("age")
    private int age;

    private double[] location;

    @PersistenceConstructor
    public PersonEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @PersistenceConstructor
    public PersonEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @PersistenceConstructor
    public PersonEntity(String name, int age, double[] location) {
        this.name = name;
        this.age = age;
        this.location = location;
    }

    @PersistenceConstructor
    public PersonEntity(String name, int age, double x, double y) {
        this.name = name;
        this.age = age;
        this.location = new double[]{x, y};
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

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double[] getLocation() {
        return location;
    }

    public void setLocation(double[] location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "PersonEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", location=" + Arrays.toString(location) +
                '}';
    }
}
