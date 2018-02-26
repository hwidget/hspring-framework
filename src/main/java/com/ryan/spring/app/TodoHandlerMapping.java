package com.ryan.spring.app;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.support.WebApplicationObjectSupport;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.AbstractUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * User:        Ryan
 * Date:        2018/2/26
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public class TodoHandlerMapping implements HandlerMapping, ApplicationContextAware {


    private ApplicationContext applicationContext;


    /**
     * Return a handler and any interceptors for this request. The choice may be made
     * on request URL, session state, or any factor the implementing class chooses.
     * <p>The returned HandlerExecutionChain contains a handler Object, rather than
     * even a tag interface, so that handlers are not constrained in any way.
     * For example, a HandlerAdapter could be written to allow another framework's
     * handler objects to be used.
     * <p>Returns {@code null} if no match was found. This is not an error.
     * The DispatcherServlet will query all registered HandlerMapping beans to find
     * a match, and only decide there is an error if none can find a handler.
     *
     * @param request current HTTP request
     * @return a HandlerExecutionChain instance containing handler object and
     * any interceptors, or {@code null} if no mapping found
     * @throws Exception if there is an internal error
     */
    @Override
    public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
        String requestURI = request.getRequestURI();

        String method = request.getMethod();

        String handlerName = "todoBean";

        Object handler = applicationContext.getBean(handlerName);

        HandlerExecutionChain handlerExecutionChain = new HandlerExecutionChain(handler);


        return handlerExecutionChain;
    }

    /**
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
