package com.ryan.spring.web.vo;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2016/12/23 15:03.
 */
public class MsgVo {

    private long msgId;

    private String message;

    public MsgVo() {
    }

    public MsgVo(long msgId, String message) {
        this.msgId = msgId;
        this.message = message;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
