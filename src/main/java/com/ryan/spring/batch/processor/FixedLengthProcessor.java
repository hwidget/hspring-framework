package com.ryan.spring.batch.processor;

import com.ryan.spring.entity.Student;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author Rayn
 * @email liuwei412552703@163.com
 * Created by Rayn on 2016/11/21 13:43.
 */
public class FixedLengthProcessor implements ItemProcessor<Student, Student> {
    /**
     * Process the provided item, returning a potentially modified or new item for continued
     * processing.  If the returned result is null, it is assumed that processing of the item
     * should not continue.
     *
     * @param student to be processed
     * @return potentially modified or new item for continued processing, null if processing of the
     * provided item should not continue.
     * @throws Exception
     */
    public Student process(Student student) throws Exception {

        student.setUid("u_" + student.getUname());

        return student;
    }
}
