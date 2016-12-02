package com.ryan.spring.web.blog.service;



import com.ryan.spring.web.blog.dao.entity.BlogsEntity;
import com.ryan.spring.web.blog.vo.Page;

import java.util.List;

/**
 * @author Rayn on 2016/7/2.
 * @email liuwei412552703@163.com.
 */
public interface BlogService {

    /**
     * 分页查询所有博客
     *
     * @param page
     */
    public List<BlogsEntity> listBlogOfPage(Page page);

    /**
     * 新增博客
     *
     * @param entity
     */
    public void addNewBlog(BlogsEntity entity);

    /**
     * 删除博客
     * @param blogId
     */
    public void deleteBlogById(String blogId);
}
