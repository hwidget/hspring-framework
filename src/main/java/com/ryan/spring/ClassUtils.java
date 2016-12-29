package com.ryan.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2016/12/29 13:07.
 */
public class ClassUtils {
    private static final Logger LOG = LoggerFactory.getLogger(ClassUtils.class);

    private static URL resource = null;

    static {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader == null) {
            loader = ClassUtils.class.getClassLoader();
        }
        resource = loader.getResource("");
    }

    /**
     * 获取当前 classpath 路径
     *
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static String currClassPath() throws URISyntaxException, IOException {
        return classpathDir().getCanonicalPath();
    }

    /**
     * 获取当前 classpath 路径
     *
     * @return
     * @throws URISyntaxException
     */
    public static File classpathDir() throws URISyntaxException {
        return new File(resource.toURI());
    }

    /**
     *
     * @return
     * @throws URISyntaxException
     */
    public static String classpathStr() throws URISyntaxException {
        return resource.getPath();
    }
}
