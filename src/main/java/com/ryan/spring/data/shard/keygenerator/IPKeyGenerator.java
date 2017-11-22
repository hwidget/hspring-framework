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
 * 根据机器IP获取工作进程编号。
 * 如果线上机器的IP二进制表示的最后10位不重复,建议使用此种方式。
 * 例如，机器的IP为192.168.1.108，二进制表示: 11000000101010000000000101101100，截取最后 10 位 0101101100，转为十进制 364，
 *      设置工作进程编号为 364。
 */
public class IPKeyGenerator {

    /**
     *
     */
    static void initWorkerId() {
        InetAddress address;

        try {
            address = InetAddress.getLocalHost();

        } catch (final UnknownHostException e) {
            throw new IllegalStateException("Cannot get LocalHost InetAddress, please check your network!");

        }

        byte[] ipAddressByteArray = address.getAddress();

        DefaultKeyGenerator.setWorkerId((long) (((ipAddressByteArray[ipAddressByteArray.length - 2] & 0B11) << Byte.SIZE) + (ipAddressByteArray[ipAddressByteArray.length - 1] & 0xFF)));
    }


    public static void main(String[] args) {

        initWorkerId();

        DefaultKeyGenerator defaultKeyGenerator = new DefaultKeyGenerator();

        for (int i = 0; i < 100000; i++) {
            System.out.println(defaultKeyGenerator.generateKey());
        }

    }
}
