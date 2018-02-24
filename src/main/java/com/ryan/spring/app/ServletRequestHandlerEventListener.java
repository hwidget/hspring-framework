package com.ryan.spring.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/**
 * <pre>
 * @author:        Ryan
 * Date:        2018/2/24
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
@Component
public class ServletRequestHandlerEventListener implements ApplicationListener<ServletRequestHandledEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(ServletRequestHandlerEventListener.class);

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ServletRequestHandledEvent event) {

        LOG.info("监听到事件 : {} -- {}", event.getServletName(), event.getClientAddress());
    }
}
