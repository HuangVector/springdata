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
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-4 16:05
 */
public class EmployeeJpaSpecificationExecutorRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository = null;

    @Before
    public void setup() {

        ctx = new ClassPathXmlApplicationContext("beans-jpa.xml");
        employeeJpaSpecificationExecutorRepository = ctx.getBean(EmployeeJpaSpecificationExecutorRepository.class);
        System.out.println("do setup!");
    }

    @After
    public void tearDown() {
        ctx = null;
        System.out.println("do tearDown!");
    }

    /**
     * 1)分页
     * 2)排序
     * 3)查询条件:age>50
     */
    @Test
    public void testQuery() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(0, 5, sort);
        /**
         * root:就是我们要查询的类型（Employee）
         * query：添加查询条件
         * cb：构建Predicate
         */
        Specification<Employee> specification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                //root (employee (age))
                Path path = root.get("age");

                return cb.gt(path, 50);
            }
        };
        Page<Employee> page = employeeJpaSpecificationExecutorRepository.findAll(specification, pageable);
        System.out.println("查询总页数: " + page.getTotalPages());
        System.out.println("查询总记录数: " + page.getTotalElements());
        System.out.println("查询当前第几页: " + (page.getNumber() + 1));
        System.out.println("查询当前页面集合: " + page.getContent());
        System.out.println("查询党员页面的记录数: " + page.getNumberOfElements());
    }
}