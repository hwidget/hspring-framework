package com.ryan.spring.data.redis.entity;

import org.springframework.data.redis.core.RedisHash;

import java.util.Map;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/23 15:58.
 */
@RedisHash("persons")
public class PersonEntity {

    private Map<String, String> attributes;
    private Map<String, PersonEntity> relatives;


    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Map<String, PersonEntity> getRelatives() {
        return relatives;
    }

    public void setRelatives(Map<String, PersonEntity> relatives) {
        this.relatives = relatives;
    }
}
