package com.ryan.spring.web.interceptor;

import com.ryan.spring.web.common.HttpRequestVisit;
import com.ryan.spring.web.common.RequestThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/12/2 16:39.
 */
public class UserAgentParseInterceptor  implements HandlerInterceptor {
    private static  final Logger log = LoggerFactory.getLogger(UserAgentParseInterceptor.class);

    /**
     *
     * @param request
     * @param response
     * @param arg2
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
//        设置visit
        RequestThread.setVisit(new HttpRequestVisit(request));
        return true;
    }

    /**
     *
     * @param request
     * @param response
     * @param arg2
     * @param arg3
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3) throws Exception {

    }

    /**
     *
     * @param request
     * @param response
     * @param arg2
     * @param arg3
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3) throws Exception {
//        清除visit
        RequestThread.setVisit(null);
    }
}
