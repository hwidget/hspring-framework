package com.ryan.spring.data.redis.pubsub;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/23 17:06.
 */
public interface MessageDelegate {

    /**
     *
     * @param message
     */
    public void handleMessage(String message);

    /**
     *
     * @param message
     */
    public void handleMessage(Map<?, ?> message);

    /**
     *
     * @param message
     */
    public void handleMessage(byte[] message);

    /**
     *
     * @param message
     */
    public void handleMessage(Serializable message);

    /**
     *
     * @param message
     * @param channel
     */
    public void handleMessage(Serializable message, String channel);
}
