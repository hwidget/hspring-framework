package com.ryan.spring.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.ryan.spring.web.common.AppException;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.http.auth.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/22 11:37.
 */
@Controller
@RequestMapping("/page")
public class BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

    /**
     *
     * @param pageName
     * @return
     */
    @RequestMapping("/{pageName}.do")
    public String goToPage(@PathVariable String pageName){
        return pageName;
    }


    /**
     * 异常页面控制
     *
     * @param runtimeException
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public ModelAndView runtimeExceptionHandler(HttpServletRequest request, HttpServletResponse response, RuntimeException runtimeException) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", false);
//        if (runtimeException instanceof  runtimeException instanceof AuthenticationException || runtimeException instanceof AuthorizationException) {
//            map.put("msg", "对不起，您没有此操作的权限");
//        } else

        if (runtimeException instanceof AppException) {
            map.put("msg", runtimeException.getMessage());
        } else {
            map.put("trace", ExceptionUtils.getFullStackTrace(runtimeException));
            map.put("msg", runtimeException.getMessage());
            LOG.error("后台出现错误:" + ExceptionUtils.getFullStackTrace(runtimeException));
        }

        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) { // EXTJS
            try {
                response.setCharacterEncoding("utf-8");
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().println(JSONObject.toJSON(map));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return new ModelAndView("admin/error", map);
        }


    }

    /**
     * Date类型的转换
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {

//        默认的Date类型使用这个format格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));


//        如果字段名称是特殊的，则使用带有日期的format格式
        DateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, "startTime", new CustomDateEditor(datetimeFormat, true));
        binder.registerCustomEditor(Date.class, "endTime", new CustomDateEditor(datetimeFormat, true));
        binder.registerCustomEditor(Date.class, "createdAt", new CustomDateEditor(datetimeFormat, true));
    }






}
