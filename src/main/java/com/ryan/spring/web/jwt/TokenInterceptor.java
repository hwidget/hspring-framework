package com.ryan.spring.web.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * <pre>
 * User:        Ryan
 * Date:        2018/2/5
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public class TokenInterceptor implements HandlerInterceptor {

    private static final Logger LOG  = LoggerFactory.getLogger(TokenInterceptor.class);

    /**
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        boolean state = false;


        String token = request.getParameter("token");

        //token不存在
        if (null != token) {


            state = true;
        }

        return state;
    }

    /**
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


    /**
     * 请求不通过，返回错误信息给客户端
     *
     * @param response
     * @param out
     * @param respJsonData
     */
    private void responseMessage(HttpServletResponse response, PrintWriter out, String respJsonData) {
        response.setContentType("application/json; charset=utf-8");
        out.print(respJsonData);
        out.flush();
        out.close();
    }
}
