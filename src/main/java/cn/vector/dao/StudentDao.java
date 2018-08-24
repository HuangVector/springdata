package cn.vector.dao;

import cn.vector.domain.Student;

import java.util.List;

/**
 * StudentDao范围接口
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-6-1 13:44
 */
public interface StudentDao {
    /**
     * 查询所有学生
     * @return 所有学生
     */
    List<Student> query();

    /**
     * 添加一个学生
     * @param student 待添加的学生
     */
    void save(Student student);
}
