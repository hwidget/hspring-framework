package com.ryan.spring.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2017/1/3 13:41.
 */
@Controller
@RequestMapping("/page")
public class HomeController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);


    /**
     *
     * @param pageName
     * @return
     */
    @RequestMapping("/{pageName}.do")
    public String gotoPage(@PathVariable String pageName){
        return pageName;
    }
}
