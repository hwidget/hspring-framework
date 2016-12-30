package com.ryan.spring.data.jpa;


import com.ryan.spring.web.blog.dao.UserInfoRepo;
import com.ryan.spring.web.blog.dao.UsersRepo;
import com.ryan.spring.web.blog.dao.entity.SupplierEntity;
import com.ryan.spring.web.blog.dao.entity.UsersEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/6/29 16:32.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:data/spring-data-jpa.xml"})
public class JpaRepoTestCase {
    private static final Logger log = LoggerFactory.getLogger(JpaRepoTestCase.class);

    @Autowired
    org.springframework.context.ApplicationContext context;

    @Autowired
    private UserInfoRepo userInfoRepo;

    @Autowired
    private UsersRepo usersRepo;

//    @Autowired
//    private UserInfoService userInfoService;

    @Before
    public void setUp() throws Exception {

    }

    /**
     * 测试 JPA 查询
     * @throws Exception
     */
    @Test
    public void testJpa() throws Exception {
        List<SupplierEntity> all = userInfoRepo.findAll();
        log.info("{}", all.size());

    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testSaveJpa() throws Exception {
        SupplierEntity supplierEntity = new SupplierEntity();
        supplierEntity.setSupplierId("121");
        supplierEntity.setSupplierName("测试");
        supplierEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        SupplierEntity save = this.userInfoRepo.save(supplierEntity);
//        this.userInfoService.saveUserInfo(supplierEntity);
        log.info("123456");

    }

    /**
     * 测试 JPA 添加用户
     * @throws Exception
     */
    @Test
    public void testSaveUser() throws Exception {
        UsersEntity user = new UsersEntity();
        user.setAge(10);
        user.setLoginname("admin");

        UsersEntity entity = usersRepo.saveAndFlush(user);
        log.info("user id : {} ", entity.getUserId());

    }
}
