package com.ryan.spring.mx4j;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/8/11
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 */
public class MyConfiguration {

    private long id = System.currentTimeMillis();

    private String name;

    public MyConfiguration() {
        super();
    }

    public MyConfiguration(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // 通过JMX管理调用时，更新id的值
        this.id = System.currentTimeMillis();
        this.name = name;
    }

    public String show() {
        StringBuffer sb = new StringBuffer().append("id=").append(id).append(", name=").append(name);
        System.out.println("show()=" + sb.toString());
        return sb.toString();
    }
}
