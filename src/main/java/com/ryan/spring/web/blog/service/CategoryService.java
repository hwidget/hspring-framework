package com.ryan.spring.web.blog.service;

/**
 * @author Rayn on 2016/7/2.
 * @email liuwei412552703@163.com.
 */
public interface CategoryService {

    /**
     * 添加分类
     *
     * @param categoryName
     * @param categoryOrder
     */
    public void addCateGory(String categoryName, Integer categoryOrder);

    /**
     * 更新
     *
     * @param categoryId
     * @param categoryName
     * @param categoryOrder
     */
    public void updateCategory(String categoryId, String categoryName, Integer categoryOrder);

    /**
     * 删除
     *
     * @param categoryId
     */
    public void removeCategoryById(String categoryId);
}
