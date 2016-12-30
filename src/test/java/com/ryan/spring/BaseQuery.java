package com.ryan.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2016/12/30 16:49.
 */
public abstract class BaseQuery {

    private static final Logger LOG = LoggerFactory.getLogger(BaseQuery.class);

    /**
     *
     * @param result
     */
    protected void print(List result){
        for (Object object : result) {
            LOG.info("查询结果：{}", object);
        }
    }



}
