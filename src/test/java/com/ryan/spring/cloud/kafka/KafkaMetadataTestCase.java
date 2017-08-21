package com.ryan.spring.cloud.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/8/21
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription: Kafka 元数据信息测试
 */
public class KafkaMetadataTestCase {

    public static final Logger LOG = LoggerFactory.getLogger(KafkaMetadataTestCase.class);

    /**
     * @throws Exception
     */
    @Test
    public void testSimpleConsumer() throws Exception {
//        SimpleConsumer simpleConsumer = new SimpleConsumer("localhost", 9092, 3000, 1024 * 5, "001");
//
//        TopicMetadataRequest topicMetadataRequest = new TopicMetadataRequest(Lists.<String>newArrayList());
//
//        TopicMetadataResponse topicMetadataResponse = simpleConsumer.send(topicMetadataRequest);
//        List<TopicMetadata> topicMetadatas = topicMetadataResponse.topicsMetadata();
//
//        for (TopicMetadata topicMetadata : topicMetadatas) {
//            LOG.info(" ===================== topic : {} ====================", topicMetadata.topic());
//
//            List<PartitionMetadata> partitionMetadatas = topicMetadata.partitionsMetadata();
//            for (PartitionMetadata partitionMetadata : partitionMetadatas) {
//                LOG.info("leader Host : {}, ISR : {}, Replicas : {}", partitionMetadata.leader().host(), partitionMetadata.isr(), partitionMetadata.replicas());
//            }
//        }
    }

    public KafkaConsumer<String, String> getKafkaConsumer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "defalut");
        props.put("enable.auto.commit", "false");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        return consumer;
    }

    /**
     * @throws Exception
     */
    @Test
    public void testKafkaConsumerPartitions() throws Exception {
        KafkaConsumer<String, String> consumer = getKafkaConsumer();

        Map<String, List<PartitionInfo>> listTopics = consumer.listTopics();

        for (Map.Entry<String, List<PartitionInfo>> entry : listTopics.entrySet()) {
            String topic = entry.getKey();
            List<PartitionInfo> partitionInfos = entry.getValue();
            for (PartitionInfo partitionInfo : partitionInfos) {
                LOG.info("laeder : {}", partitionInfo.leader().host(), partitionInfo.partition(), partitionInfo.replicas(), partitionInfo.topic());
            }

        }
    }

    /**
     * Kafka 订阅发布
     *
     * @throws Exception
     */
    @Test
    public void testKafkaSubscribe() throws Exception {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "defalut");
        props.put("enable.auto.commit", "false");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        consumer.subscribe(Arrays.asList("foo", "bar"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s", record.offset(), record.key(), record.value());
        }

    }
}
