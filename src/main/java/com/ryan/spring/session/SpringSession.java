package com.ryan.spring.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/4/14
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
@Service
public class SpringSession {

    private static final Logger LOG = LoggerFactory.getLogger(SpringSession.class);

    @Autowired
    private SessionRepository repo;

    /**
     * 获取Session
     *
     * @param sessionId
     */
    public void sessionOp(String sessionId) {
        Session session = repo.getSession(sessionId);

        Set<String> attributeNames = session.getAttributeNames();
        for (String attributeName : attributeNames) {
            LOG.info(attributeName);
        }

    }


}
