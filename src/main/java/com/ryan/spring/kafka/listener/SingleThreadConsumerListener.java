package com.ryan.spring.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/24 12:41.
 */
public class SingleThreadConsumerListener implements MessageListener<Integer, String> {

    private static final Logger LOG = LoggerFactory.getLogger(SingleThreadConsumerListener.class);

    /**
     *
     * @param record
     */
    @Override
    public void onMessage(ConsumerRecord<Integer, String> record) {

        LOG.info("接收到消息:{}", record.value());
    }
}
