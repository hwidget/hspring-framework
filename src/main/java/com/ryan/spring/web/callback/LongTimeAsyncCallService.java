package com.ryan.spring.web.callback;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/22 11:25.
 */
@Component("longTimeAsyncCallService")
public class LongTimeAsyncCallService {

    private final int CorePoolSize = 4;
    private final int NeedSeconds = 3;
    private Random random = new Random();
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(CorePoolSize);


    public void makeRemoteCallAndUnknownWhenFinish(final LongTermTaskCallback callback) {
        System.out.println("完成此任务需要 : " + NeedSeconds + " 秒");
        scheduler.schedule(new Runnable() {
            @Override
            public void run() {
                callback.callback("长时间异步调用完成.");
            }
        }, 0, TimeUnit.SECONDS);
    }
}
