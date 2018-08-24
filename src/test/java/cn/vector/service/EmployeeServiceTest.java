package cn.vector.service;

import cn.vector.domain.Employee;
import cn.vector.repository.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-4 14:27
 */
public class EmployeeServiceTest {
private ApplicationContext ctx = null;
    //private EmployeeRepository employeeRepository = null;
    private EmployeeService employeeService = null;

    @Before
    public void setup() {

        ctx = new ClassPathXmlApplicationContext("beans-jpa.xml");
        //employeeRepository = ctx.getBean(EmployeeRepository.class);
        employeeService = ctx.getBean(EmployeeService.class);
        System.out.println("do setup!");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("do tearDown!");

    }
    @Test
    public void updateAge() {
        employeeService.updateAge(1,55);
    }
    @Test
    public void save(){
        List<Employee> employeeList = new ArrayList<Employee>();
        Employee employee = null;
        for(int i = 0; i<100; i++){
            employee = new Employee();
            employee.setName("test_"+i);
            employee.setAge(100 - i);
            employeeList.add(employee);
        }
        employeeService.save(employeeList);
    }
}