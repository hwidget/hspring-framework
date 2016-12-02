package com.ryan.spring.web.common;

/**
 * @author Rayn on 2016/7/2.
 * @email liuwei412552703@163.com.
 */
public class AppException extends RuntimeException {

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable throwable) {
        super(message,throwable);
    }
}
