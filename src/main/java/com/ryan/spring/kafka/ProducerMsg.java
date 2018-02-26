package com.ryan.spring.kafka;

import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * <pre>
 * User:        Ryan
 * Date:        2018/2/26
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public class ProducerMsg implements IKafkaConfig {

    public static final Logger LOG = LoggerFactory.getLogger(ProducerMsg.class);


    private KafkaProducer<String, String> producer = null;

    private AtomicBoolean initFlag = new AtomicBoolean(false);
    private Properties props = null;

    /**
     *
     */
    public void init() {
        props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put("kafka.topic", topic);

        producer = new KafkaProducer<String, String>(props);
    }

    /**
     * 同步方式发送数据到 kafka
     * @param data
     * @param callback
     */
    public void send(String data, Callback callback) {

        if (!initFlag.get()) {
            init();
            initFlag.set(true);
        }

        producer.send(new ProducerRecord<String, String>(props.getProperty("kafka.topic").toString(), data), callback);
    }


    /**
     *  异步方式发送数据到 kafka
     * @param data
     */
    public void send(String data){
        if (!initFlag.get()) {
            init();
            initFlag.set(true);
        }
        producer.send(new ProducerRecord<String, String>(props.getProperty("kafka.topic").toString(), data));
    }

    public static void main(String[] args) {

        ProducerMsg producerMsg = new ProducerMsg();

        for (int i = 0; i < 1000; i++) {
            producerMsg.send("这里是测试发送消息 -- " + i, new Callback(){

                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    System.out.println(" be sended to partition no : " + metadata.partition());
                }
            });
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
