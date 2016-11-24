package com.ryan.spring.cloud.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.listener.config.ContainerProperties;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/24 10:48.
 */
public class SpringKafkaTestCase {
    private static final Logger LOG = LoggerFactory.getLogger(SpringKafkaTestCase.class);

    private String topic = "yaxin-test";
    private String group = "default-group";

    private KafkaMessageListenerContainer<Integer, String> createContainer(ContainerProperties containerProps) {
        Map<String, Object> props = consumerProps();
        DefaultKafkaConsumerFactory<Integer, String> cf = new DefaultKafkaConsumerFactory<Integer, String>(props);


        KafkaMessageListenerContainer<Integer, String> container = new KafkaMessageListenerContainer<Integer, String>(cf, containerProps);
        return container;
    }

    /**
     * @return
     */
    private Map<String, Object> consumerProps() {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, group);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }

    private Map<String, Object> senderProps() {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

    /**
     * @return
     */
    private KafkaTemplate<Integer, String> createTemplate() {
        Map<String, Object> senderProps = senderProps();
        ProducerFactory<Integer, String> pf = new DefaultKafkaProducerFactory<Integer, String>(senderProps);
        KafkaTemplate<Integer, String> template = new KafkaTemplate<Integer, String>(pf);
        return template;
    }

    /**
     * Kafka 生产消费
     *
     * @throws Exception
     */
    @Test
    public void testKafkaProductAndConsumer() throws Exception {
        LOG.info("Start auto");
        ContainerProperties containerProps = new ContainerProperties("yaxin-test", "topic2");
        KafkaMessageListenerContainer<Integer, String> container = createContainer(containerProps);
        final CountDownLatch latch = new CountDownLatch(4);
        containerProps.setMessageListener(new MessageListener<Integer, String>() {
            @Override
            public void onMessage(ConsumerRecord<Integer, String> message) {
                LOG.info("received: " + message);
                latch.countDown();
            }
        });

        container.setupMessageListener(new MessageListener<Integer, String>() {
            @Override
            public void onMessage(ConsumerRecord<Integer, String> message) {
                LOG.info("received: " + message);
                latch.countDown();
            }
        });
        container.setBeanName("testAuto");
        container.start();
        Thread.sleep(1000); // wait a bit for the container to start
        KafkaTemplate<Integer, String> template = createTemplate();
        template.setDefaultTopic(topic);
        template.sendDefault(0, "foo");
        template.sendDefault(2, "bar");
        template.sendDefault(0, "baz");
        template.sendDefault(2, "qux");
        template.flush();

        assertTrue(latch.await(60, TimeUnit.SECONDS));

        container.stop();
        LOG.info("Stop auto");


    }

    /**
     * 发布消息后回调
     *
     * @throws Exception
     */
    @Test
    public void testSendMsgCallback() throws Exception {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-kafka.xml");
        KafkaTemplate kafkaTemplate = applicationContext.getBean("kafkaTemplate", KafkaTemplate.class);

        ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.sendDefault("foo");
        future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {

            @Override
            public void onSuccess(SendResult<Integer, String> result) {

            }

            @Override
            public void onFailure(Throwable ex) {

            }

        });

    }

    /**
     * 测试Kafka生产者
     *
     * @throws Exception
     */
    @Test
    public void testProducer() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("kafka/spring-kafka-producer.xml");

        KafkaTemplate kafkaTemplate = applicationContext.getBean("kafkaTemplate", KafkaTemplate.class);

        for (int i = 0; i < 100; i++) {
            kafkaTemplate.send("yaxin-test", "测试发送数据:" + i);

            LOG.info("现在发送第 {} 条信息.", i);
            Thread.sleep(2000);
        }
        LOG.info("数据发送完毕.");

        kafkaTemplate.flush();
    }

    /**
     * 测试 消费者
     *
     * @throws Exception
     */
    @Test
    public void testConsumer() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("kafka/spring-kafka-consumer.xml");
        applicationContext.start();

        while(true){

            LOG.info("current time: " + new Date());

            Thread.sleep(2000);
        }
    }
}
