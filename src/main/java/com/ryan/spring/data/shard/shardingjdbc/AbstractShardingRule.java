package com.ryan.spring.data.shard.shardingjdbc;

import javax.sql.DataSource;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/11/4
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public abstract class AbstractShardingRule {

    protected String host = "192.168.1.8";
    protected int port = 3306;
    protected String uname = "root";
    protected String upass = "123456";


    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    /**
     *
     * @return
     */
    public DataSource getDataSource() {

        return null;
    }


    /**
     * 执行
     */
    public abstract void run();

}
