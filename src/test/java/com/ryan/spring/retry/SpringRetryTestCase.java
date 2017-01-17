package com.ryan.spring.retry;

import org.junit.Test;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2017/1/17 9:23.
 */
public class SpringRetryTestCase {

    /**
     * 从事机制
     *
     * @throws Exception
     */
    @Test
    public void testSpringRetry() throws Exception {
        RetryTemplate template = new RetryTemplate();


        TimeoutRetryPolicy policy = new TimeoutRetryPolicy();
        policy.setTimeout(300L);

        template.setRetryPolicy(policy);

        Result result = template.execute(new RetryCallback<Result, Exception>() {

            public Result doWithRetry(RetryContext context) {
                // Do stuff that might fail, e.g. webservice

                return new Result();
            }

        }, new RecoveryCallback<Result>() {
            @Override
            public Result recover(RetryContext retryContext) throws Exception {


                return null;
            }
        });

        String msg = result.getMsg();

    }
}
