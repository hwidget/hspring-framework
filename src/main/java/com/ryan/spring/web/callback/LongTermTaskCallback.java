package com.ryan.spring.web.callback;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/22 11:24.
 */
public interface LongTermTaskCallback {

    /**
     * @param result
     */
    public void callback(Object result);
}
