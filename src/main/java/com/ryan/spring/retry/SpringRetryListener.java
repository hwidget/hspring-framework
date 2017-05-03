package com.ryan.spring.retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2017/1/17 9:21.
 */
public class SpringRetryListener implements RetryListener {

    private static final Logger LOG = LoggerFactory.getLogger(SpringRetryListener.class);

    @Override
    public <T, E extends Throwable> boolean open(RetryContext retryContext, RetryCallback<T, E> retryCallback) {
        LOG.info("SpringRetryListener open method invoke.");



        return false;
    }

    @Override
    public <T, E extends Throwable> void onError(RetryContext retryContext, RetryCallback<T, E> retryCallback, Throwable throwable) {
        LOG.info("SpringRetryListener onError method invoke.");
    }

    @Override
    public <T, E extends Throwable> void close(RetryContext retryContext, RetryCallback<T, E> retryCallback, Throwable throwable) {

        LOG.info("SpringRetryListener close method invoke.");

    }
}
