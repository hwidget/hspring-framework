package com.ryan.spring.web.blog.service.impl;

import com.ryan.spring.web.blog.dao.UserInfoRepo;
import com.ryan.spring.web.blog.dao.entity.SupplierEntity;
import com.ryan.spring.web.blog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/6/29 16:54.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepo userInfoRepo;

    /**
     * 保存用户信息
     *
     * @param supplier
     */
    @Override
    public void saveUserInfo(SupplierEntity supplier) {
        SupplierEntity supplierEntity = this.userInfoRepo.saveAndFlush(supplier);

        System.out.println("保存成功!");
    }
}
