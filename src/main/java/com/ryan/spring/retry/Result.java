package com.ryan.spring.retry;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2017/1/17 9:24.
 */
public class Result {

    private boolean success;

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
