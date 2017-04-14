# Spring Framework
============================================================================
# 延迟加载过滤器
    <filter>
        <filter-name>hibernateFilter</filter-name>
        <filter-class>
        org.springframework.orm.hibernate3.support.OpenSessionInViewFilter
        </filter-class>
    </filter>
    <filter-mapping>
        <filter-name>hibernateFilter</filter-name>
        <url-pattern>*.html</url-pattern>
    </filter-mapping>

# 中文乱码过滤器

① 指定 Log4J 配置文件的地址
<context-param>
    <param-name>log4jConfigLocation</param-name>
    <param-value>/WEB-INF/log4j.properties</param-value>
</context-param>
② 使用该监听器初始化 Log4J 日志引擎
<listener>
    <listener-class>
    org.springframework.web.util.Log4jConfigListener
    </listener-class>
</listener>
Introspector 缓存清除监听器,防止内存泄露
<listener>
    <listener-class>
    org.springframework.web.util.IntrospectorCleanupListener
    </listener-class>
</listener>