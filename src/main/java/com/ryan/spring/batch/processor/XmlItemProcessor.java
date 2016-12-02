package com.ryan.spring.batch.processor;

import com.ryan.spring.data.entity.Student;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/21 12:58.
 */
public class XmlItemProcessor implements ItemProcessor<Student, Student> {


    /**
     * @param student
     * @return
     * @throws Exception
     */
    public Student process(Student student) throws Exception {

        student.setUname("uname_" + student.getUname());

        return student;
    }
}
