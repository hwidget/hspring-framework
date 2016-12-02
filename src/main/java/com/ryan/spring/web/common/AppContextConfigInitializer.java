package com.ryan.spring.web.common;

import org.springframework.web.context.WebApplicationContext;

import java.util.Properties;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/6/20 13:56.
 */
public class AppContextConfigInitializer {

    public static org.springframework.context.ApplicationContext context = null;

    public static void initAppContextConfig(org.springframework.context.ApplicationContext context) {
        AppContextConfigInitializer.context = context;
        // 配置文件properties
        Properties config = (Properties) context.getBean("config");


        //网站ROOT URL
        AppContext.siteBaseUrl = config.getProperty("site_baseUrl");
        AppContext.adminSessionKey = config.getProperty("appSessionKey", "");

        //如果配置的ROOT URL 最后是/，则删除掉最后的/，防止两个//引起的路径问题
        if (AppContext.siteBaseUrl.trim().endsWith("/")) {
            AppContext.siteBaseUrl = AppContext.siteBaseUrl.substring(0, AppContext.siteBaseUrl.length() - 1);
        }


        if (context instanceof WebApplicationContext) {
            WebApplicationContext webApplicationContext = (WebApplicationContext) context;
            //项目绝对路径
            AppContext.appRealPath = webApplicationContext.getServletContext().getRealPath("");
            //放入到servletContext全局变量中，方便页面使用
            webApplicationContext.getServletContext().setAttribute("basePath", ((WebApplicationContext) context).getServletContext().getContextPath());
        }


        /**
         * 邮件属性
         */
        Properties mailProperties = new Properties();
        mailProperties.setProperty("mail.smtp.auth", "true");
        mailProperties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        AppContext.mailHost = config.getProperty("stmp_server");
        AppContext.mailPort = Integer.parseInt(config.getProperty("stmp_port", "23"));
        AppContext.mailName = config.getProperty("stmp_username");
        String stmp_password = config.getProperty("stmp_password");

    }
}
