package cn.vector.repository;

import cn.vector.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-4 14:40
 */
public interface EmployeeCrudRepository extends CrudRepository<Employee,Integer>{
}
