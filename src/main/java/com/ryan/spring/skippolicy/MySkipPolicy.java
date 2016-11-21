package com.ryan.spring.skippolicy;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/21 14:16.
 */
public class MySkipPolicy implements SkipPolicy {


    /**
     *
     * @param t
     * @param skipCount
     * @return
     * @throws SkipLimitExceededException
     */
    public boolean shouldSkip(Throwable t, int skipCount) throws SkipLimitExceededException {


        return false;
    }
}
