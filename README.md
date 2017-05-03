Spring Framework
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

# Spring Retry 模块
RetryPolicy提供了如下策略实现：

    * NeverRetryPolicy：只允许调用RetryCallback一次，不允许重试；
    * AlwaysRetryPolicy：允许无限重试，直到成功，此方式逻辑不当会导致死循环；
    * SimpleRetryPolicy：固定次数重试策略，默认重试最大次数为3次，RetryTemplate默认使用的策略；
    * TimeoutRetryPolicy：超时时间重试策略，默认超时时间为1秒，在指定的超时时间内允许重试；
    * CircuitBreakerRetryPolicy：有熔断功能的重试策略，需设置3个参数openTimeout、resetTimeout和delegate，稍后详细介绍该策略；
    * CompositeRetryPolicy：组合重试策略，有两种组合方式，乐观组合重试策略是指只要有一个策略允许重试即可以，悲观组合重试策略是指只要有一个策略不允许重试即可以，但不管哪种组合方式，组合中的每一个策略都会执行。
    
BackOffPolicy 提供了如下策略实现：

    * NoBackOffPolicy：无退避算法策略，即当重试时是立即重试；
    * FixedBackOffPolicy：固定时间的退避策略，需设置参数sleeper和backOffPeriod，sleeper指定等待策略，默认是Thread.sleep，即线程休眠，backOffPeriod指定休眠时间，默认1秒；
    * UniformRandomBackOffPolicy：随机时间退避策略，需设置sleeper、minBackOffPeriod和maxBackOffPeriod，该策略在[minBackOffPeriod,maxBackOffPeriod之间取一个随机休眠时间，minBackOffPeriod默认500毫秒，maxBackOffPeriod默认1500毫秒；
    * ExponentialBackOffPolicy：指数退避策略，需设置参数sleeper、initialInterval、maxInterval和multiplier，initialInterval指定初始休眠时间，默认100毫秒，maxInterval指定最大休眠时间，默认30秒，multiplier指定乘数，即下一次休眠时间为当前休眠时间*multiplier；
    * ExponentialRandomBackOffPolicy：随机指数退避策略，引入随机乘数，之前说过固定乘数可能会引起很多服务同时重试导致DDos，使用随机休眠时间来避免这种情况。

CircuitBreakerRetryPolicy需要配置三个参数：
    * delegate：是真正判断是否重试的策略，当重试失败时，则执行熔断策略；
    * openTimeout：openWindow，配置熔断器电路打开的超时时间，当超过openTimeout之后熔断器电路变成半打开状态（主要有一次重试成功，则闭合电路）；
    * resetTimeout：timeout，配置重置熔断器重新闭合的超时时间。
