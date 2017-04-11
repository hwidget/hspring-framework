package com.ryan.spring;

import com.ryan.spring.web.controller.HomeController;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/3/16
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public class ControllerTestCase extends SpringJUnit4SpringContextTests {


    @Test
    public void testName() throws Exception {
        HomeController loginController = (HomeController) this.applicationContext.getBean("homeController");
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setMethod("POST");
        request.addParameter("username", "aa");
        request.addParameter("password", "bb");
        loginController.gotoPage("1");

    }
}
