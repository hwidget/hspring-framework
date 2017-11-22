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
 * 浏览 IPKeyGenerator 工作进程编号生成的规则后，感觉对服务器IP后10位（特别是IPV6）数值比较约束。
 * 有以下优化思路：
 * 因为工作进程编号最大限制是 2^10，我们生成的工程进程编号只要满足小于 1024 即可。
 * 1.针对IPV4:
 * ....IP最大 255.255.255.255。而（255+255+255+255) < 1024。
 * ....因此采用IP段数值相加即可生成唯一的workerId，不受IP位限制。
 *
 * 针对IPV6:
 * ....IP最大 ffff:ffff:ffff:ffff:ffff:ffff:ffff:ffff
 * ....为了保证相加生成出的工程进程编号 < 1024,思路是将每个 Bit 位的后6位相加。这样在一定程度上也可以满足workerId不重复的问题。
 * 使用这种 IP 生成工作进程编号的方法,必须保证IP段相加不能重复.
 *
 * 对于 IPV6 ：2^ 6 = 64。64 * 8 = 512 < 1024。
 */
public class IPSectionKeyGenerator {

    // IPSectionKeyGenerator.java
    static void initWorkerId() {
        InetAddress address;

        try {
            address = InetAddress.getLocalHost();

        } catch (final UnknownHostException e) {
            throw new IllegalStateException("Cannot get LocalHost InetAddress, please check your network!");
        }

        byte[] ipAddressByteArray = address.getAddress();
        long workerId = 0L;


        // IPV4
        if (ipAddressByteArray.length == 4) {
            for (byte byteNum : ipAddressByteArray) {
                workerId += byteNum & 0xFF;
            }
            // IPV6
        } else if (ipAddressByteArray.length == 16) {
            for (byte byteNum : ipAddressByteArray) {
                workerId += byteNum & 0B111111;
            }
        } else {
            throw new IllegalStateException("Bad LocalHost InetAddress, please check your network!");
        }

        DefaultKeyGenerator.setWorkerId(workerId);
    }


    public static void main(String[] args) {

        initWorkerId();

        DefaultKeyGenerator defaultKeyGenerator = new DefaultKeyGenerator();

        for (int i = 0; i < 100000; i++) {
            System.out.println(defaultKeyGenerator.generateKey());
        }

    }
}
