package com.ryan.spring.web.blog.service;


import com.ryan.spring.web.blog.dao.entity.SupplierEntity;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/6/29 16:54.
 */
public interface UserInfoService {

    /**
     * 保存用户信息
     * @param supplier
     */
    public void saveUserInfo(SupplierEntity supplier);



}
