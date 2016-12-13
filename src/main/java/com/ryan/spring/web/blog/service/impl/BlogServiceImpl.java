package com.ryan.spring.web.blog.service.impl;

import com.ryan.spring.web.blog.dao.BlogsRepo;
import com.ryan.spring.web.blog.dao.entity.BlogsEntity;
import com.ryan.spring.web.blog.service.BlogService;
import com.ryan.spring.web.blog.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 博客信息
 *
 * @author Rayn on 2016/7/2.
 * @email liuwei412552703@163.com.
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogsRepo blogsRepo;

    /**
     * 分页查询所有博客
     *
     * @param page
     */
    @Override
    public List<BlogsEntity> listBlogOfPage(Page page) {
        return null;
    }

    /**
     * 新增博客
     *
     * @param entity
     */
    @Override
    public void addNewBlog(BlogsEntity entity) {

    }

    /**
     * 删除博客
     *
     * @param blogId
     */
    @Override
    public void deleteBlogById(String blogId) {

    }
}
