package com.ryan.spring.vo;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * <pre>
 * User:        Ryan
 * Date:        2018/2/24
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public class BeanWarpExample {

    public static void main(String[] args) {

        PersonVo personVo = new PersonVo();

        BeanWrapper propertyAccess = PropertyAccessorFactory.forBeanPropertyAccess(personVo);

        propertyAccess.setPropertyValue("uname", "张三李四王五");
        propertyAccess.setPropertyValue("uid", "10001");

        System.out.println("Person - uname = " + personVo.getUname());

        PropertyValue propertyValue = new PropertyValue("upass", "123456");
        propertyAccess.setPropertyValue(propertyValue);

        System.out.println("Person - upass = " + personVo.getUpass());



    }
}
