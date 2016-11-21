package com.ryan.spring.batch.writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/21 10:47.
 */
public class HelloWriterTasklet implements Tasklet {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWriterTasklet.class);


    private String message;

    public HelloWriterTasklet() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @param contribution
     * @param chunkContext
     * @return
     * @throws Exception
     */
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        System.out.println(message);

        return RepeatStatus.FINISHED;
    }
}
