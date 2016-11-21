package com.ryan.spring.batch;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/21 10:50.
 */
public class SpringBatchTestCase {

    private static final Logger LOG = LoggerFactory.getLogger(SpringBatchTestCase.class);

    @Before
    public void setUp() throws Exception {


    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testHelloWriterJob() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("batch/spring-job-hello.xml");
        JobLauncher launcher = context.getBean("jobLauncher", JobLauncher.class);

        Job job = context.getBean("helloWorldJob", Job.class);

        try {
            /**
             * 运行 Job
             */
            JobExecution result = launcher.run(job, new JobParameters());

            /**
             * 处理结束，控制台打印处理结果
             */
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFileJob() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("batch/spring-job-file.xml");
        JobLauncher launcher = context.getBean("jobLauncher", JobLauncher.class);

        Job job = context.getBean("csvFileJob", Job.class);

        try {
            /**
             * 运行 Job
             */
            JobExecution result = launcher.run(job, new JobParameters());

            /**
             * 处理结束，控制台打印处理结果
             */
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
