package com.ryan.spring.kafka.listener;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.ProducerListenerAdapter;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/24 11:20.
 */
public class MsgProducerListener extends ProducerListenerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(MsgProducerListener.class);


    /**
     *
     * @param topic
     * @param partition
     * @param key
     * @param value
     * @param recordMetadata
     */
    @Override
    public void onSuccess(String topic, Integer partition, Object key, Object value, RecordMetadata recordMetadata) {
        super.onSuccess(topic, partition, key, value, recordMetadata);

        LOG.info("生产者消息 OnMessage : offset [{}]  partition [{}]", recordMetadata.offset(), recordMetadata.partition());

    }

    /**
     *
     * @param topic
     * @param partition
     * @param key
     * @param value
     * @param exception
     */
    @Override
    public void onError(String topic, Integer partition, Object key, Object value, Exception exception) {
        super.onError(topic, partition, key, value, exception);

        LOG.info("发送消息 Topic :{}, Partition : {}, Key : {}, Value : {}", topic, partition, key, value, exception.getMessage());

    }
}
