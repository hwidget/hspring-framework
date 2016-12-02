package com.ryan.spring.web.blog.controller;

import com.spring.mvc.manger.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 博客评论
 *
 * @author Rayn on 2016/7/2.
 * @email liuwei412552703@163.com.
 */
@Controller
@RequestMapping("/comment")
public class CommentsController extends BaseController {


    /**
     * 评论列表
     *
     * @param bolgId
     */
    @ResponseBody
    @RequestMapping("/list.do")
    public Map<String, Object> listOfComment(String bolgId) {
        Map<String, Object> response = new HashMap<String, Object>();


        return response;
    }

    /**
     * 添加评论
     *
     * @param bolgId
     */
    @ResponseBody
    @RequestMapping("/add.do")
    public Map<String, Object> addComment(String bolgId) {
        Map<String, Object> response = new HashMap<String, Object>();


        return response;
    }

    /**
     * 修改评论
     *
     * @param bolgId
     */
    @ResponseBody
    @RequestMapping("/upd.do")
    public Map<String, Object> updateComment(String bolgId) {
        Map<String, Object> response = new HashMap<String, Object>();


        return response;
    }

    /**
     * 删除评论
     *
     * @param commentId
     */
    @ResponseBody
    @RequestMapping("/remove.do")
    public Map<String, Object> removeComment(String commentId) {
        Map<String, Object> response = new HashMap<String, Object>();


        return response;
    }
}
