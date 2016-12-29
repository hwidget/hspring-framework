package com.ryan.spring.freemarker;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2016/12/29 13:28.
 */
public class ProductVo {

    private String url;

    private String name;

    public ProductVo() {
    }

    public ProductVo(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
