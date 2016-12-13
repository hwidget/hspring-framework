package com.ryan.spring.web.common;

import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;

/**
 * 网页访问者的信息
 *
 * @author Administrator
 */
public class HttpRequestVisit {

    private String userAgent;
    private String ip;
    private String device;
    private String os;
    private String browser;
    private String browserVersion;

    /**
     * 传入HttpServletRequest解析User-agent中的信息
     *
     * @param request
     */
    public HttpRequestVisit(HttpServletRequest request) {
        try {
            this.userAgent = request.getHeader("User-Agent");
            this.ip = RequestIP.getIpAddr(request);
            UserAgent ua = null;
            try {
                ua = UserAgent.parseUserAgentString(this.userAgent);
            } catch (Exception e) {

            }
            if (ua == null) {
                return;
            }
            this.device = ua.getOperatingSystem().getDeviceType().getName();
            this.os = ua.getOperatingSystem().getName();
            this.browser = ua.getBrowser().getGroup().getName();
            this.browserVersion = ua.getBrowserVersion().getVersion();
        } catch (Exception e) {

        }
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

}
