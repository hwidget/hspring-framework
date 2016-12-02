package com.ryan.spring.web.blog.service;

import com.spring.mvc.blog.dao.entity.CommentsEntity;

/**
 * @author Rayn on 2016/7/2.
 * @email liuwei412552703@163.com.
 */
public interface CommentService {

    /**
     * 添加评论
     *
     * @param entity
     */
    public void addComment(CommentsEntity entity);
}
