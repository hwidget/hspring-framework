package com.ryan.spring.web.blog.controller;

import com.ryan.spring.web.controller.BaseController;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 博客信息
 *
 * @author Rayn on 2016/7/2.
 * @email liuwei412552703@163.com.
 */
@Controller
@RequestMapping("/blogs")
public class BlogsController extends BaseController {


    /**
     * 获取博客列表
     *
     * @param page
     * @param type
     */
    @ResponseBody
    @RequestMapping("/list.do")
    public Map<String, Object> listOfBlogs(Page page, int type) {
        Map<String, Object> response = new HashMap<String, Object>();


        return response;
    }

    /**
     * 添加博客
     */
    @ResponseBody
    @RequestMapping("/add.do")
    public Map<String, Object> addBlogs() {
        Map<String, Object> response = new HashMap<String, Object>();


        return response;
    }

    /**
     * 更新博客内容信息
     */
    @ResponseBody
    @RequestMapping("/update.do")
    public Map<String, Object> updateBlogs() {
        Map<String, Object> response = new HashMap<String, Object>();


        return response;
    }

    /**
     * 更新博客内容信息
     *
     * @param blogsId
     */
    @ResponseBody
    @RequestMapping("/remove.do")
    public Map<String, Object> deleteBlogs(String blogsId) {
        Map<String, Object> response = new HashMap<String, Object>();


        return response;
    }
}
