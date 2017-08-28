package com.ryan.spring.invoker.service.impl;

import com.ryan.spring.invoker.service.UserInfoService;
import com.ryan.spring.invoker.vo.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/8/28
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public class UserInfoServiceImpl implements UserInfoService {

    private static Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);


    /**
     *
     * @param userName
     * @return
     */
    @Override
    public UserInfo getUserInfobyName(String userName) {
        UserInfo user = null;
        try {
            user = new UserInfo();
            logger.debug("get userinfo success by username:" + userName);
        } catch (Throwable t) {
            logger.error("get userinfo fail by username:" + userName, t);
        }
        return user;
    }

    /**
     * 记录错误日志
     * @param username
     * @param point
     * @param operate
     * @param desc
     * @return
     */
    public int recordLog(String username, String point, String operate, String desc) {
        int result = 0;
        try {
            logger.info(username + " - " + point + " - " + operate + " - " + desc);
        } catch (Exception t) {
            result = -1;
            logger.error("", t);
        }
        return result;
    }


}
