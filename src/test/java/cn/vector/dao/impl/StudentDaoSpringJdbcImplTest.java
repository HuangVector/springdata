package cn.vector.dao.impl;

import cn.vector.dao.StudentDao;
import cn.vector.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-1 15:41
 */
public class StudentDaoSpringJdbcImplTest {
    private ApplicationContext ctx = null;
    private StudentDao studentDao = null;

    @Before
    public void setup() {
        System.out.println("do setup!");
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDao = (StudentDao) ctx.getBean("studentDao");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("do tearDown!");

    }

    @Test
    public void query() {
        List<Student> studentList = studentDao.query();
        for (Student student : studentList) {
            System.out.println("id : " + student.getId()
                    + ", name : " + student.getName()
                    + ", age : " + student.getAge());
        }
    }

    @Test
    public void save() {
        Student student = new Student();
        student.setName("test-jdbc");
        student.setAge(30);
        studentDao.save(student);
    }
}