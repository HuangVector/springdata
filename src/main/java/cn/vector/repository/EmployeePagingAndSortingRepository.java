package cn.vector.repository;

import cn.vector.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-4 15:02
 */
public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee, Integer> {

}
