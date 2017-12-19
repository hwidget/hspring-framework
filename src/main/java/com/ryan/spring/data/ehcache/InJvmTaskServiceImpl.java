package com.ryan.spring.data.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/12/18
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
@Service
public class InJvmTaskServiceImpl implements InJvmTaskService, InitializingBean {

    private static final Logger LOG = LoggerFactory.getLogger(InJvmTaskServiceImpl.class);

    @Autowired
    private CacheManager cache;


    @Override
    public void afterPropertiesSet() throws Exception {
        Cache cache = this.cache.getCache("cachetest");

        for (int i = 0; i < 500; i++) {
            String uuid = UUID.randomUUID().toString();
            cache.put(new Element(i + uuid, uuid));
            System.out.println(i + uuid);
        }

        run();
    }

    /**
     *
     */
    public void run() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean state = true;

                while (state) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        String taskUrn = produceJob();
                        System.out.println("消费: " + taskUrn);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }


    /**
     * @return
     */
    @Override
    public String produceJob() {

        Cache cachetest = cache.getCache("cachetest");

        String taskUrn = null;
        try {
            taskUrn = cachetest.getKeys().iterator().next().toString();
            boolean removeQuiet = cachetest.removeQuiet(taskUrn);

            if (!removeQuiet) {
                taskUrn = produceJob();
            }

        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {

        }

        return taskUrn;
    }

    /**
     * @return
     */
    @Override
    public String consumerJob() {

        return null;
    }
}
