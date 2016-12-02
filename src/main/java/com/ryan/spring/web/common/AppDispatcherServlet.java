package com.ryan.spring.web.common;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能：支持根据RootApplicationContext中的情况配置动态加载 SpringMVC 配置文件
 *
 * Created by Rayn on 2015/12/16.
 */
public class AppDispatcherServlet extends DispatcherServlet {

    Logger log = LoggerFactory.getLogger(AppDispatcherServlet.class);

    @Override
    protected void onRefresh(ApplicationContext context) {
        super.onRefresh(context);
        //初始化配置
        AppContextConfigInitializer.initAppContextConfig(context);

    }


    /**
     * 根据情况动态修改配置文件路径
     *
     * @param wac
     */
    @Override
    protected void postProcessWebApplicationContext(ConfigurableWebApplicationContext wac) {
        super.postProcessWebApplicationContext(wac);

        //origin == spring-mvc-servlet.xml
        String origin = getContextConfigLocation();

        WebApplicationContext webApplicationContext = (WebApplicationContext) this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

        List<String> configFile = new ArrayList<>();
        configFile.add(origin);
        configFile.add("classpath:init-project-setup.xml");

        wac.setConfigLocation(StringUtils.join(configFile, ","));
    }

}
