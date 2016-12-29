package com.ryan.spring.freemarker;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.ryan.spring.utils.ClassUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Rayn
 * @Vendor liuwei412552703@163.com
 * Created by Rayn on 2016/12/29 11:41.
 */
public class FreeMarkerTestCase {

    private static final Logger LOG = LoggerFactory.getLogger(FreeMarkerTestCase.class);

    private Configuration cfg = null;


    @Before
    public void setUp() throws Exception {

        // Create your Configuration instance, and specify if up to what FreeMarker version (here 2.3.25) do you want to apply the fixes that are not 100%
        // backward-compatible. See the Configuration JavaDoc for details.
        cfg = new Configuration(Configuration.VERSION_2_3_23);

        // Specify the source where the template files come from. Here I set a plain directory for it, but non-file-system sources are possible too:
        cfg.setDirectoryForTemplateLoading(ClassUtils.classpathDir());

        // Set the preferred charset template files are stored in. UTF-8 is a good choice in most applications:
        cfg.setDefaultEncoding("UTF-8");

        // Sets how errors will appear. During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // Don't log exceptions inside FreeMarker that it will thrown at you anyway:
        cfg.setLogTemplateExceptions(true);


    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * @throws Exception
     */
    @Test
    public void testName() throws Exception {

        File file = new File(ClassUtils.classpathStr(), "datadir/test.htmlh");
        Template template = new Template("test.htmlh", Files.toString(file, Charsets.UTF_8), cfg);

        Writer out = new OutputStreamWriter(System.out);

        Map<String, Object> datas = new HashMap<String, Object>();
        datas.put("name", "测试");
        datas.put("user", "Ryan");
        datas.put("latestProduct", new ProductVo("http://www.baiud.com", "baidu URL "));

        try {
            template.process(datas, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }
    }
}