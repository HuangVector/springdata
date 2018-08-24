package cn.vector.repository;

import cn.vector.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-4 15:55
 */
public interface EmployeeJpaSpecificationExecutorRepository extends JpaRepository<Employee,Integer>,JpaSpecificationExecutor<Employee> {
}
