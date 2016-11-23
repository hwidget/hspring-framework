package com.ryan.spring.data.redis.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/23 16:10.
 */
public class DefaultMessageDelegate implements MessageDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultMessageDelegate.class);


    public void handleMessage(String message) {
        LOG.info("handleMessage(String message) 接收到消息：{}", message);
    }

    public void handleMessage(Map<?, ?> message) {

        LOG.info("handleMessage(Map<?, ?> message) 接收到消息：{}", message);
    }

    public void handleMessage(byte[] message) {


        LOG.info("handleMessage(byte[] message) handleMessage 接收到消息：{}", new String(message));
    }

    public void handleMessage(Serializable message) {
        LOG.info("handleMessage(Serializable message) 接收到消息：{}", message);
    }

    public void handleMessage(Serializable message, String channel) {
        LOG.info("handleMessage(Serializable message, String channel) 接收到消息:{}", message.toString());
    }
}
