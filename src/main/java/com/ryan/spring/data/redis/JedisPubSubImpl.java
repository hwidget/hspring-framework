package com.ryan.spring.data.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPubSub;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/23 16:30.
 */
public class JedisPubSubImpl extends JedisPubSub {

    private static final Logger LOG = LoggerFactory.getLogger(JedisPubSubImpl.class);


    @Override
    public void onMessage(String channel, String message) {

        LOG.info("接收到消息:{}, 消息内容为:{}", channel, message);
    }
}
