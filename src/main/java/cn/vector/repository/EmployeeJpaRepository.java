package cn.vector.repository;

import cn.vector.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-4 15:29
 */
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer>{
}
