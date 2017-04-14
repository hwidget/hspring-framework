package com.ryan.spring.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

import java.io.*;
import java.util.Properties;

/**
 * Spring 自带的工具类
 *
 * @author Rayn on 2017/4/11.
 * @email liuwei412552703@163.com.
 */
public class SpringInnerUtils {

    private static final Logger LOG = LoggerFactory.getLogger(SpringInnerUtils.class);


    /**
     * 访问文件资源
     * <p/>
     * 通过 FileSystemResource 以文件系统绝对路径的方式进行访问；
     * 通过 ClassPathResource 以类路径的方式进行访问；
     * 通过 ServletContextResource 以相对于 Web 应用根目录的方式进行访问。
     */
    public void loadFile() {
        try {
            String filePath = "D:/masterSpring/chapter23/webapp/WEB-INF/classes/conf/file1.txt";

            // ① 使用系统文件路径方式加载文件
            Resource res1 = new FileSystemResource(filePath);
            InputStream ins1 = res1.getInputStream();
            System.out.println("res1:" + res1.getFilename());


            // ② 使用类路径方式加载文件
            Resource res2 = new ClassPathResource("conf/file1.txt");
            InputStream ins2 = res2.getInputStream();
            System.out.println("res2:" + res2.getFilename());


            File clsFile = ResourceUtils.getFile("classpath:conf/file1.txt");
            System.out.println(clsFile.isFile());

            String httpFilePath = "file:D:/masterSpring/chapter23/src/conf/file1.txt";
            File httpFile = ResourceUtils.getFile(httpFilePath);


            // ① jdbc.properties 是位于类路径下的文件
            Properties props = PropertiesLoaderUtils.loadAllProperties("jdbc.properties");
            System.out.println(props.getProperty("jdbc.driverClassName"));


//            ServletContextResource(application,url);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件操作
     */
    public void fileCopy() throws IOException {
        Resource res = new ClassPathResource("conf/file1.txt");

        // ① 将文件内容拷贝到一个 byte[] 中
        byte[] fileData = FileCopyUtils.copyToByteArray(res.getFile());

        // ② 将文件内容拷贝到一个 String 中
        String fileStr = FileCopyUtils.copyToString(new FileReader(res.getFile()));

        // ③ 将文件内容拷贝到另一个目标文件
        FileCopyUtils.copy(res.getFile(), new File(res.getFile().getParent() + "/file2.txt"));

        // ④ 将文件内容拷贝到一个输出流中
        OutputStream os = new ByteArrayOutputStream();
        FileCopyUtils.copy(res.getInputStream(), os);


    }

    /**
     * 读取指定编码格式文件
     *
     * @throws IOException
     */
    public void encodeFile() throws IOException {
        Resource res = new ClassPathResource("conf/file1.txt");
        // ① 指定文件资源对应的编码格式（UTF-8）
        EncodedResource encRes = new EncodedResource(res, "UTF-8");
        // ② 这样才能正确读取文件的内容，而不会出现乱码
        String content = FileCopyUtils.copyToString(encRes.getReader());
        System.out.println(content);



//        ServletContext servletContext = request.getSession().getServletContext();
//        WebApplicationContext wac = WebApplicationContextUtils. getWebApplicationContext(servletContext);
    }


    /**
     *
     */
    public void escapeChar(){
        String str = "<html><title>测试标题</title></html>";

        JavaScriptUtils.javaScriptEscape(str);

        /**
         * 转换为HTML转义字符表示
         */
        String htmlEscape = HtmlUtils.htmlEscape(str);

        /**
         * 转换为数据转义表示
         */
        String htmlEscapeDecimal = HtmlUtils.htmlEscapeDecimal(str);

        /**
         * 转换为十六进制数据转义表示
         */
        String htmlEscapeHex = HtmlUtils.htmlEscapeHex(str);

        /**
         * 将经过转义内容还原
         */
        String htmlUnescape = HtmlUtils.htmlUnescape(str);
    }
}