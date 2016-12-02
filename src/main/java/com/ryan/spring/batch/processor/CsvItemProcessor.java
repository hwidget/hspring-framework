package com.ryan.spring.batch.processor;

import com.ryan.spring.data.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/21 11:38.
 */
public class CsvItemProcessor implements ItemProcessor<Student, Student> {
    private static final Logger LOG = LoggerFactory.getLogger(CsvItemProcessor.class);


    /**
     * 对数据进行清洗操作
     *
     * @param student
     * @return
     * @throws Exception
     */
    public Student process(Student student) throws Exception {
        student.setUname(student.getUname() + "#" + student.getUname());


        return student;
    }
}
