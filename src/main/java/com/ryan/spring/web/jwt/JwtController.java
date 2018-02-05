package com.ryan.spring.web.jwt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * User:        Ryan
 * Date:        2018/2/5
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 *
 *      JWT （ Json Web Token )
 */
@Controller
@RequestMapping("/jwt")
public class JwtController {


    /**
     * JWT 测试首页
     *
     * @return
     */
    @RequestMapping("index")
    public String jwtIndex() {
        return "jwtIndex";
    }


    /**
     *
     * @param request
     * @param email
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "login", produces = "application/json; charset=utf-8")
    public Map<String, Object> login(HttpServletRequest request, @RequestParam("email") String email, @RequestParam("password") String password) {
        Map<String, Object> resp = new HashMap<String, Object>();



        return resp;
    }

}
