package com.ryan.spring.batch.reader;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/21 10:49.
 */
public class HelloReaderTasklet implements Tasklet {



    /**
     * @param contribution
     * @param chunkContext
     * @return
     * @throws Exception
     */
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {


        return null;
    }
}
