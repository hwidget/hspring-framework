package com.ryan.spring.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.event.ListenerContainerIdleEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * Kafka 消费者事件监听
 *
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/24 11:31.
 */
public class MsgConsumerListener {
    private static final Logger LOG = LoggerFactory.getLogger(MsgConsumerListener.class);

    /**
     * @param foo
     * @param ack
     */
    @KafkaListener(id = "kafkaListenerMsg", topics = "yaxin-test")
    public void kafkaListenerMsg(@Payload String foo, Acknowledgment ack) {


        ack.acknowledge();
    }

    /**
     * @param record
     */
    @KafkaListener(id = "explicitListen", topicPartitions = {@TopicPartition(topic = "yaxin-test", partitions = {"0", "1"}),
            @TopicPartition(topic = "topic2", partitions = "0", partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "100"))})
    public void explicitListen(ConsumerRecord<?, ?> record) {

    }


    /**
     * @param data
     * @param ack
     */
    @KafkaListener(id = "baz", topics = "yaxin-test", containerFactory = "kafkaListenerContainerFactory")
    public void listenOfContainer(String data, Acknowledgment ack) {
        LOG.info("listenOfContainer ： {}", data);

        ack.acknowledge();
    }

    /**
     *
     * @param foo
     * @param key
     * @param partition
     * @param topic
     */
    @KafkaListener(id = "qux", topicPattern = "yaxin-test")
    public void listen(@Payload String foo, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) Integer key,
                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {


        LOG.info("message key : {}, PartitionId : {}, Topic : {}", key, partition, topic);
    }

    /**
     * 事件监听
     *
     * @param event
     */
    @EventListener(condition = "event.listenerId.startsWith('qux-')")
    public void eventHandler(ListenerContainerIdleEvent event) {


    }
}
