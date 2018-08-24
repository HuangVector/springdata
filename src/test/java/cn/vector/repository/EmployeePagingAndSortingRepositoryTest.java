package cn.vector.repository;

import cn.vector.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.junit.Assert.*;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-4 15:06
 */
public class EmployeePagingAndSortingRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeePagingAndSortingRepository  employeePagingAndSortingRepository = null;

    @Before
    public void setup() {

        ctx = new ClassPathXmlApplicationContext("beans-jpa.xml");
        employeePagingAndSortingRepository = ctx.getBean(EmployeePagingAndSortingRepository.class);
        System.out.println("do setup!");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("do tearDown!");
    }

    @Test
    public void testPage(){
        Pageable pageable = new PageRequest(2, 10);

        Page<Employee> page =  employeePagingAndSortingRepository.findAll(pageable);
        System.out.println("查询总页数: "+page.getTotalPages());
        System.out.println("查询总记录数: "+page.getTotalElements());
        System.out.println("查询当前第几页: "+(page.getNumber()+1));
        System.out.println("查询当前页面集合: "+page.getContent());
        System.out.println("查询党员页面的记录数: "+page.getNumberOfElements());

    }
    @Test
    public void testPageAndSort(){
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);

        Pageable pageable = new PageRequest(0, 5, sort);

        Page<Employee> page =  employeePagingAndSortingRepository.findAll(pageable);
        System.out.println("查询总页数: "+page.getTotalPages());
        System.out.println("查询总记录数: "+page.getTotalElements());
        System.out.println("查询当前第几页: "+(page.getNumber()+1));
        System.out.println("查询当前页面集合: "+page.getContent());
        System.out.println("查询党员页面的记录数: "+page.getNumberOfElements());

    }
}