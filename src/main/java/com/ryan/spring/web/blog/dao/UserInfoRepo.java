package com.ryan.spring.web.blog.dao;


import com.ryan.spring.web.blog.dao.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/6/29 16:29.
 */
public interface UserInfoRepo extends JpaRepository<SupplierEntity, Integer> {

}
