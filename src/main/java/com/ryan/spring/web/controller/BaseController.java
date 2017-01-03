package com.ryan.spring.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.ryan.spring.web.common.AppException;
import com.ryan.spring.web.entity.User;
import com.ryan.spring.web.uitls.StringEscapeEditor;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.http.auth.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
public abstract class BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;



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


        binder.registerCustomEditor(String.class, new StringEscapeEditor(true));// html转义
    }

    /**
     * 初始化分页查询参数Page
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    protected Pageable initPage(Integer pageNo, Integer pageSize) {
        // @RequestParam在处理不存在的参数时，赋值为null，基本类型无法为null，改为包装类型
        if (pageNo == null) {
            pageNo = 0;
        }
        if (pageSize == null) {
            pageSize = 0;
        }
        pageNo = pageNo == 0 ? 0 : pageNo - 1;
        pageSize = pageSize == 0 ? 10 : pageSize;
        Pageable page = new PageRequest(pageNo, pageSize);
        return page;
    }

    /**
     * 初始化分页查询参数Page
     *
     * @param pageNo
     * @param pageSize
     * @param direction
     * @param properties
     * @return
     */
    protected Pageable initPage(Integer pageNo, Integer pageSize, Sort.Direction direction, String... properties) {
        if (pageNo == null) {
            pageNo = 0;
        }
        if (pageSize == null) {
            pageSize = 0;
        }
        pageNo = pageNo == 0 ? 0 : pageNo - 1;
        pageSize = pageSize == 0 ? 10 : pageSize;
        Pageable page = new PageRequest(pageNo, pageSize, direction, properties);
        return page;
    }

    /**
     * 重定向到指定url
     * @param url
     * @return
     */
    protected String redirectTo(String url) {
        StringBuilder rto = new StringBuilder("redirect:");
        rto.append(url);
        return rto.toString();
    }

    /**
     * 获取项目根路径
     * @return
     */
    protected String getContextPath() {
        return request.getContextPath();
    }

    /**
     * 设置用户
     * @param user
     */
    protected void setUser(User user) {
        request.getSession().setAttribute("user", user);
    }

    /**
     * 获取用户
     * @return
     */
    protected User getUser() {
        User user = (User) request.getSession().getAttribute("user");
        return user;
    }

    /**
     * 移动用户
     */
    protected void removeUser() {
        request.getSession().removeAttribute("user");
        request.getSession().invalidate();
    }


}
