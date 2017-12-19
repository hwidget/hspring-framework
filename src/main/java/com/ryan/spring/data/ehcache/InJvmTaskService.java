package com.ryan.spring.data.ehcache;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/12/18
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public interface InJvmTaskService {

    /**
     * 获取任务
     * @return
     */
    public String produceJob();


    /**
     *
     * @return
     */
    public String consumerJob();
}
