package cn.vector.dao.impl;

import cn.vector.dao.StudentDao;
import cn.vector.domain.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-1 14:23
 */
public class StudentDaoImplTest {

    @Test
    public void query() {
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> studentList = studentDao.query();
        for (Student student:studentList) {
            System.out.println("id : "+ student.getId()
                + ", name : "+student.getName()
                + ", age : "+student.getAge());
        }
    }
    @Test
    public void save(){
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student();
        student.setName("test");
        student.setAge(30);
        studentDao.save(student);
    }
}