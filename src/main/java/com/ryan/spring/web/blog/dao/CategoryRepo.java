package com.ryan.spring.web.blog.dao;

import com.ryan.spring.web.blog.dao.entity.CategorysEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rayn on 2016/7/2.
 * @email liuwei412552703@163.com.
 */
public interface CategoryRepo extends JpaRepository<CategorysEntity, Integer> {
}
