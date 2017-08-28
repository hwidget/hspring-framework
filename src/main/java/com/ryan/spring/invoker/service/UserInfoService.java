package com.ryan.spring.invoker.service;

import com.ryan.spring.invoker.vo.UserInfo;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/8/28
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public interface UserInfoService {

    /**
     * 通过用户名称获取用户信息
     *
     * @param userName
     * @return
     */
    public UserInfo getUserInfobyName(String userName);


    /**
     *
     * @param username
     * @param point
     * @param operate
     * @param desc
     * @return
     */
    public int recordLog(String username, String point, String operate, String desc);
}
