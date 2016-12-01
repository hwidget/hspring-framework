package com.ryan.spring.data.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTableInterfaceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/12/1 10:03.
 */
public class HBasePoolTableFactory implements HTableInterfaceFactory {

    private static final Logger LOG = LoggerFactory.getLogger(HBasePoolTableFactory.class);

    protected static Configuration hbaseConfiguration;
    private int maxIdxConnection = 5;


    public HBasePoolTableFactory(Configuration hbaseConfiguration) {
        this.hbaseConfiguration = hbaseConfiguration;
        this.maxIdxConnection = hbaseConfiguration.getInt("htable.poll.maxidx.connection", 5);
    }


    public HTableInterface createHTableInterface(Configuration configuration, byte[] bytes) {
        return null;
    }

    public void releaseHTableInterface(HTableInterface hTableInterface) throws IOException {

    }
}


