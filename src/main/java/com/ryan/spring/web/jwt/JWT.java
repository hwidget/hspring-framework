package com.ryan.spring.web.jwt;

/**
 * <pre>
 * User:        Ryan
 * Date:        2018/2/5
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.HashMap;
import java.util.Map;

public class JWT {
    private static final String SECRET = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";

    private static final String EXP = "exp";

    private static final String PAYLOAD = "payload";

    /**
     * 加密，传入一个对象和有效期
     *
     * @param object
     * @param maxAge
     * @param <T>
     * @return
     */
    public static <T> String sign(T object, long maxAge) {


        return null;
    }

    /**
     * 解密，传入一个加密后的token字符串和解密后的类型
     *
     * @param jwt
     * @param classT
     * @param <T>
     * @return
     */
    public static <T> T unsign(String jwt, Class<T> classT) {


        return null;
    }

}