package com.ryan.spring.web.common;

/**
 * 项目运行时环境或全局设置
 * <p>
 * /
 * 项目文件夹所在磁盘的路径
 */
public class AppContext {
    protected static String appRealPath = "";
    /**
     * 项目根路径完整URL
     */
    protected static String siteBaseUrl = "";

    /**
     * 管理员登录状态在session中的key
     */
    protected static String adminSessionKey;
    /**
     * 微信授权TOKEN保存在session中的key
     */
    protected static String wxTokenKey;


    protected static String mailHost;
    protected static int mailPort;
    protected static String mailName;
    protected static String mailPwd;


    public static String ndTrackerPattern;
    public static String ndTrackerMobileIosPattern;
    public static String ndTrackerMobileAndoridPattern;
    public static String ndTrackerPcPattern;

    /**
     * DMP标签URL地址
     */
    public static String dmpTagsURL;


    /**
     * 关键词 二期 url地址
     */

    public static String keyWordUrl;

    public static String getKeyWordUrl() {
        return keyWordUrl;
    }

    public static void setKeyWordUrl(String keyWordUrl) {
        AppContext.keyWordUrl = keyWordUrl;
    }

    /**
     * 返回项目所在目录的路径
     *
     * @return
     */
    public static String getAppRealPath() {
        return appRealPath;
    }

    /**
     * 返回ND监控格式
     *
     * @return
     */
    @Deprecated
    public static String getNdTrackerPattern() {
        return ndTrackerPattern;
    }

    /**
     * IOS移动端监控格式
     *
     * @return
     */
    public static String getNdTrackerMobileIosPattern() {
        return ndTrackerMobileIosPattern;
    }

    /**
     * Android移动端监控格式
     *
     * @return
     */
    public static String getNdTrackerMobileAndoridPattern() {
        return ndTrackerMobileAndoridPattern;
    }

    /**
     * PC端监控格式
     *
     * @return
     */
    public static String getNdTrackerPcPattern() {
        return ndTrackerPcPattern;
    }

    /**
     * 返回项目的根URL
     *
     * @return
     */
    public static String getSiteBaseUrl() {
        return siteBaseUrl;
    }

    /**
     * 返回AdminUser信息在session中的key
     *
     * @return
     */
    public static String getAdminSessionKey() {
        return adminSessionKey;
    }


    public static String getWxTokenKey() {
        return wxTokenKey;
    }

    public static String getDmpTagsURL() {
        return dmpTagsURL;
    }

    public static void setDmpTagsURL(String dmpTagsURL) {
        AppContext.dmpTagsURL = dmpTagsURL;
    }

    public static String getMailHost() {
        return mailHost;
    }

    public static int getMailPort() {
        return mailPort;
    }

    public static String getMailName() {
        return mailName;
    }

    public static String getMailPwd() {
        return mailPwd;
    }

}
