package cn.vector.repository;

import cn.vector.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-4 15:31
 */
public class EmployeeJpaRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeeJpaRepository employeeJpaRepository = null;

    @Before
    public void setup() {

        ctx = new ClassPathXmlApplicationContext("beans-jpa.xml");
        employeeJpaRepository = ctx.getBean(EmployeeJpaRepository.class);
        System.out.println("do setup!");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("do tearDown!");
    }

    @Test
    public void testFind() {
        Employee employee = employeeJpaRepository.findOne(99);
        System.out.println("employee:" + employee);
        System.out.println("employee(10):" + employeeJpaRepository.exists(10));
        System.out.println("employee(120):" + employeeJpaRepository.exists(120));
    }
}