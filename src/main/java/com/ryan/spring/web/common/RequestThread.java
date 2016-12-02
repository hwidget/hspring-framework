package com.ryan.spring.web.common;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/7/7 17:09.
 */

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 返回当前线程绑定的后台登录用户
 */
public class RequestThread {
    /**
     * 本次请求
     */
    private static final ThreadLocal<HttpRequestVisit> visit = new ThreadLocal<HttpRequestVisit>();
    /**
     * Handlermethod中发生的异常
     */
    private static final ThreadLocal<RuntimeException> exception = new ThreadLocal<RuntimeException>();


    /**
     * 重置
     */
    public static void reset() {
        visit.remove();
        exception.remove();
    }


    /**
     * 解析请求的客户端信息
     *
     * @param visitObject
     */
    public static void setVisit(HttpRequestVisit visitObject) {
        visit.set(visitObject);
    }

    /**
     * 获取或客户端信息
     *
     * @return
     */
    public static HttpRequestVisit getVisit() {
        return visit.get();
    }

    /**
     * 设置异常
     *
     * @param e
     */
    public static void setException(RuntimeException e) {
        exception.set(e);
    }

    /**
     * 获取异常
     *
     * @return
     */
    public static RuntimeException getException() {
        return exception.get();
    }

    /**
     * 返回当前线程的 HttpServletRequest
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    /**
     * 返回当前线程的 HttpServletResponse
     *
     * @return
     */
    public static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
    }
}