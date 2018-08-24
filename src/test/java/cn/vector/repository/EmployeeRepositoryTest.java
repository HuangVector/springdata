package cn.vector.repository;

import cn.vector.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-4 8:35
 */
public class EmployeeRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeeRepository employeeRepository = null;


    @Before
    public void setup() {

        ctx = new ClassPathXmlApplicationContext("beans-jpa.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("do setup!");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("do tearDown!");

    }

    @Test
    public void findByName() {
        System.out.println("do findByName");
        System.out.println(employeeRepository);
        Employee employee = employeeRepository.findByName("张三");
        System.out.println(employee.getId());
    }

    @Test
    public void findByNameStartingWithAndAgeLessThan() {
        List<Employee> employeeList = employeeRepository.findByNameStartingWithAndAgeLessThan("test", 21);
        for (Employee employee : employeeList) {
            System.out.println("id: " + employee.getId() + ", "
                    + "name: " + employee.getName() + ", "
                    + "age: " + employee.getAge());
        }
    }

    @Test
    public void findByNameEndingWithAndAgeLessThan() {
        List<Employee> employeeList = employeeRepository.findByNameEndingWithAndAgeLessThan("9", 25);
        for (Employee employee : employeeList) {
            System.out.println("id: " + employee.getId() + ", "
                    + "name: " + employee.getName() + ", "
                    + "age: " + employee.getAge());
        }
    }

    @Test
    public void findByNameInAndAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employeeList = employeeRepository.findByNameInAndAgeLessThan(names, 22);
        for (Employee employee : employeeList) {
            System.out.println("id: " + employee.getId() + ", "
                    + "name: " + employee.getName() + ", "
                    + "age: " + employee.getAge());
        }
    }

    @Test
    public void findByNameInOrAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employeeList = employeeRepository.findByNameInOrAgeLessThan(names, 22);
        for (Employee employee : employeeList) {
            System.out.println("id: " + employee.getId() + ", "
                    + "name: " + employee.getName() + ", "
                    + "age: " + employee.getAge());
        }
    }

    @Test
    public void getEmployeeByMaxId() {
        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println("id: " + employee.getId() + ", "
                + "name: " + employee.getName() + ", "
                + "age: " + employee.getAge());
    }

    @Test
    public void QueryParams1() {
        List<Employee> employeeList = employeeRepository.QueryParams1("test7", 22);
        for (Employee employee : employeeList) {
            System.out.println("id: " + employee.getId() + ", "
                    + "name: " + employee.getName() + ", "
                    + "age: " + employee.getAge());
        }
    }

    @Test
    public void QueryParams2() {
        List<Employee> employeeList = employeeRepository.QueryParams2("test7", 23);
        for (Employee employee : employeeList) {
            System.out.println("id: " + employee.getId() + ", "
                    + "name: " + employee.getName() + ", "
                    + "age: " + employee.getAge());
        }
    }

    @Test
    public void QueryLike1() {
        List<Employee> employeeList = employeeRepository.QueryLike1("7");
        for (Employee employee : employeeList) {
            System.out.println("id: " + employee.getId() + ", "
                    + "name: " + employee.getName() + ", "
                    + "age: " + employee.getAge());
        }
    }
    @Test
    public void QueryLike2() {
        List<Employee> employeeList = employeeRepository.QueryLike2("9");
        for (Employee employee : employeeList) {
            System.out.println("id: " + employee.getId() + ", "
                    + "name: " + employee.getName() + ", "
                    + "age: " + employee.getAge());
        }
    }
    @Test
    public void getCount(){
        System.out.println("count: "+employeeRepository.getCount());
    }

    @Test
    public void updateAge(){
        employeeRepository.updateAge(1,55);
    }
}