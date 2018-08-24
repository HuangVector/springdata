package cn.vector.service;

import cn.vector.domain.Employee;
import cn.vector.repository.EmployeeCrudRepository;
import cn.vector.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-4 14:23
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void updateAge(Integer id, Integer age){
        employeeRepository.updateAge(id, age);
    }
    @Transactional
    public void save(List<Employee> employeeList){
        employeeCrudRepository.save(employeeList);
    }
}
