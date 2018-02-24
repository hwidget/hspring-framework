package com.ryan.spring.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2017/1/3 13:41.
 */
@Controller
@RequestMapping("/page")
public class HomeController extends BaseController implements EnvironmentAware, ApplicationContextAware {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    private Environment env = null;

    private ApplicationContext applicationContext = null;

    /**
     * Set the {@code Environment} that this object runs in.
     *
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     *
     * @param pageName
     * @return
     */
    @RequestMapping("/{pageName}.do")
    public String gotoPage(@PathVariable String pageName){
        return pageName;
    }
}
