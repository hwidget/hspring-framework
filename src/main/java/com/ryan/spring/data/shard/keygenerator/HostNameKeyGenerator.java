package com.ryan.spring.data.shard.keygenerator;

import com.dangdang.ddframe.rdb.sharding.keygen.DefaultKeyGenerator;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <pre>
 * User:        Ryan
 * Date:        2017/11/22
 * Email:       liuwei412552703@163.com
 * Version      V1.0
 * Discription:
 *
 * 根据机器名最后的数字编号获取工作进程编号。
 * 如果线上机器命名有统一规范,建议使用此种方式。
 * 例如，机器的 HostName 为: dangdang-db-sharding-dev-01(公司名-部门名-服务名-环境名-编号)，会截取 HostName 最后的编号 01 作为工作进程编号( workId )。
 */
public class HostNameKeyGenerator {

    public HostNameKeyGenerator() {
        initWorkerId();
    }

    /**
     *
     */
    public static void initWorkerId() {
        InetAddress address;
        Long workerId;

        try {
            address = InetAddress.getLocalHost();
        } catch (final UnknownHostException e) {
            throw new IllegalStateException("Cannot get LocalHost InetAddress, please check your network!");

        }
        String hostName = address.getHostName();

        //临时测试
        hostName = "work-1";

        try {
            workerId = Long.valueOf(hostName.replace(hostName.replaceAll("\\d+$", ""), ""));
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(String.format("Wrong hostname:%s, hostname must be end with number!", hostName));
        }
        DefaultKeyGenerator.setWorkerId(workerId);
    }


    public static void main(String[] args) {

        initWorkerId();

        DefaultKeyGenerator defaultKeyGenerator1 = new DefaultKeyGenerator();

        for (int i = 0; i < 100000; i++) {
            System.out.println(defaultKeyGenerator1.generateKey());
        }

    }
}
